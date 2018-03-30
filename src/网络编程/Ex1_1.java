package 网络编程;

public class Ex1_1
{

    static public long sum(final int[] array)
    {
        if(array == null || array.length == 0)
        {
            throw new IllegalArgumentException("array length must greater than 0");
        }
        final RuntimeData rd = new RuntimeData();
        int threadCount = rd.getThreadCount(array);
        System.out.println("thread count:" + threadCount);
        // 每线程计算的数组元素个数
        final int lenPerThread = array.length / threadCount;
        System.out.println("number:" + lenPerThread);
        for(int i = 0; i < threadCount; i++)
        {
            final int index = i;
            new Thread()
            {
                @Override
                public void run()
                {
                    long s = 0;
                    int start = index * lenPerThread;
                    int end = start + lenPerThread;
                    for(int j = start; j < end; j++)
                    {
                        s += array[j];
                    }
                    synchronized(rd)
                    {
                        rd.sum += s;
                        rd.finishThreadCount++;
                        // System.out.println("thread[" + getName() + "]  finished,sum:" + d.sum);
                    }

                }

                ;
            }.start();
        }

        // 余下的array元素
        int remain = array.length % threadCount;
        System.out.println("remain element count:" + remain);
        long s = 0;
        for(int i = array.length - remain; i < array.length; i++)
        {
            s += array[i];
        }
        synchronized(rd)
        {
            rd.sum += s;
        }
        while(rd.finishThreadCount != threadCount)
        {
            try
            {
                Thread.sleep(1);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
                break;
            }
        }
        return rd.sum;
    }

    public static void main(String[] args)
    {
        int[] array = new int[10000000];
        @SuppressWarnings("unused")
        long s = System.currentTimeMillis();
        long sum = 0;
        for(int i = 0; i < array.length; i++)
        {
            array[i] = i;
            sum += array[i];
        }
        long start = System.currentTimeMillis();
        // System.out.println("time:" + (start - s));
        long sum2 = sum(array);
        long end = System.currentTimeMillis();
        long cost = end - start;
        // System.out.println(sum);
        // System.out.println(sum2 == sum);
        System.out.println("sum:" + sum + "\nequals:" + (sum2 == sum) + "\ncost:" + cost);
    }

}

class RuntimeData
{
    // 保存和
    long sum;
    // 默认线程数
    int defThreadCount = 12;
    // 已经执行完成的线程数
    int finishThreadCount;

    public int getThreadCount(int[] array)
    {
        if(array.length < defThreadCount)
        {
            return array.length;
        }
        return defThreadCount;
    }

}