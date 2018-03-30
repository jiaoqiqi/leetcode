package 网络编程;

import 网络编程.RuntimeData;

public class Ex2_1
{
    public static int binarySearch(int a[], int b, int c, int target)
    {

        int mid = (b + c) / 2;

        if(b > c || target < a[b] || target > a[c])
        {

            // 不满足基本条件，返回-1

            return -1;

        }
        else
        {

            if(target > a[mid])
            {

                return binarySearch(a, mid + 1, c, target);

            }

            else
                if(target < a[mid])
                {

                    return binarySearch(a, b, mid - 1, target);

                }

                else
                {

                    // 找到，返回下标

                    return mid;

                }

        }

    }

    static public long find(final int[] array, int m, int k)
    {
        if(array == null || array.length == 0)
        {
            throw new IllegalArgumentException("array length must greater than 0");
        }
        final 网络编程.RuntimeData rd = new 网络编程.RuntimeData();
        int threadCount = k;
        System.out.println("thread count:" + threadCount);
        // 每线程计算的数组元素个数
        final int lenPerThread = array.length / threadCount;
        // System.out.println("number:" + lenPerThread);
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
                    int end = start + lenPerThread - 1;
                    if(index == threadCount - 1)
                        end = array.length - 1;
                    s = binarySearch(array, start, end, m);
                    synchronized(rd)
                    {
                        if(s != -1)
                            rd.sum += s;
                        rd.finishThreadCount++;
                    }

                }

                ;
            }.start();
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
        int k = 4;
        int[] array = new int[10000000];
        @SuppressWarnings("unused")
        long s = System.currentTimeMillis();
        int num = 1234567;
        for(int i = 0; i < array.length; i++)
        {
            array[i] = i;
        }
        long start = System.currentTimeMillis();
        long sum2 = find(array, num, k);
        long end = System.currentTimeMillis();
        long cost = end - start;
        System.out.println("位置:" + sum2 + "\ncost:" + cost);
    }
}
