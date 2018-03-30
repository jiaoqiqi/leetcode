package 网络编程;

import 网络编程.RuntimeData;

import java.util.Random;

public class Ex1_2
{
    static public long sum(long m, int k)
    {
        // m是运算次数，k是线程数
        long threadcount = m / k;
        // 平均每个线程计算的数目
        网络编程.RuntimeData rData = new 网络编程.RuntimeData();

        for(int i = 0; i < k; i++)
        {
            int index = i;
            new Thread()
            {
                public void run()
                {
                    long s = 0;
                    long start = index * threadcount;
                    long end;
                    if(index == k - 1)
                    {
                        end = m;
                    }
                    else
                    {
                        end = start + threadcount;
                    }
                    double a = 1;
                    // 取4分之一正方形
                    double x, y;

                    Random random = new Random();
                    for(long j = start; j < end; j++)
                    {
                        x = random.nextDouble();
                        y = random.nextDouble();
                        if(x * x + y * y <= a * a)
                            s = s + 1;
                    }
                    synchronized(rData)
                    {
                        rData.sum += s;
                        rData.finishThreadCount++;
                    }
                };
            }.start();
        }
        while(rData.finishThreadCount != k)
        {
            try
            {
                Thread.sleep(1);
            }
            catch(InterruptedException e)
            {
                e.printStackTrace();
                break;
                // TODO: handle exception
            }
        }
        return rData.sum;

    }

    public static void main(String args[])
    {
        long m = 10000000;
        int k = 4; // 线程数
        @SuppressWarnings("unused")
        long s = System.currentTimeMillis();
        long start = System.currentTimeMillis();
        long pi = sum(m, k);
        long end = System.currentTimeMillis();
        long cost = end - start;
        System.out.println("次数:" + m + "\n线程数:" + k + "\nPi=" + (double) pi * 4 / m + "\n耗时:"
                + cost);
    }
}
