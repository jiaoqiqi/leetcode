package 网络编程;

import 网络编程.RuntimeData;

import java.util.Random;

public class Ex2_3
{
    public static int[] quickSort(int[] strData, int left, int right)
    {
        int middle, tempData;
        int i, j;
        i = left;
        j = right;
        middle = strData[(i + j) / 2];
        do
        {
            while(strData[i] < middle && i < right)
                i++;
            while(strData[j] > middle && j > left)
                j--;
            if(i <= j)
            {
                tempData = strData[i];
                strData[i] = strData[j];
                strData[j] = tempData;
                i++;
                j--;
            }

        }
        while(i <= j);
        if(i < right)
        {
            quickSort(strData, i, right);
        }
        if(j > left)
        {
            quickSort(strData, left, j);
        }
        return strData;
    }

    public static int[] thread(int[] array, int k)
    {
        int threadcount = array.length / k;
        // 平均每个线程计算的数目
        网络编程.RuntimeData rData = new 网络编程.RuntimeData();
        rData.finishThreadCount = 0;
        for(int h = 0; h < k; h++)
        {
            int index = h;
            new Thread()
            {
                public void run()
                {
                    int start, end;
                    @SuppressWarnings("unused")
                    int m = 0;
                    start = index * threadcount;
                    end = start + threadcount - 1;
                    if(index == k - 1)
                    {
                        end = array.length - 1;
                    }
                    quickSort(array, start, end);
                    synchronized(rData)
                    {
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
        return array;
    }

    public static void main(String args[])
    {
        int array[] = new int[1000000];
        int k = 4;
        Random random = new Random();
        for(int i = 0; i < array.length; i++)
        {
            array[i] = random.nextInt(1000);
        }
        long start = System.currentTimeMillis();
        array = thread(array, k);
        array = quickSort(array, 0, array.length - 1);
        long end = System.currentTimeMillis();
        long cost = end - start;
        System.out.println("cost:" + cost);

        System.out.println(array[1234]);
        System.out.println(array[125135]);
        System.out.println(array[925135]);
    }
}
