package 网络编程;

import 网络编程.RuntimeData;

import java.util.Random;

public class Ex2_2
{
    public static int[] sort(int[] a, int low, int high)
    {
        int mid = (low + high) / 2;
        if(low < high)
        {
            sort(a, low, mid);
            sort(a, mid + 1, high);
            // 左右归并
            merge(a, low, mid, high);
        }
        return a;
    }

    public static void merge(int[] a, int low, int mid, int high)
    {
        int[] temp = new int[high - low + 1];
        int i = low;
        int j = mid + 1;
        int k = 0;
        // 把较小的数先移到新数组中
        while(i <= mid && j <= high)
        {
            if(a[i] < a[j])
            {
                temp[k++] = a[i++];
            }
            else
            {
                temp[k++] = a[j++];
            }
        }
        // 把左边剩余的数移入数组
        while(i <= mid)
        {
            temp[k++] = a[i++];
        }
        // 把右边边剩余的数移入数组
        while(j <= high)
        {
            temp[k++] = a[j++];
        }
        // 把新数组中的数覆盖nums数组
        for(int x = 0; x < temp.length; x++)
        {
            a[x + low] = temp[x];
        }
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
                    sort(array, start, end);
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
        int k = 2;
        Random random = new Random();
        for(int i = 0; i < array.length; i++)
        {
            array[i] = random.nextInt(1000);
        }

        long start = System.currentTimeMillis();
        array = thread(array, k);
        array = sort(array, 0, array.length - 1);
        long end = System.currentTimeMillis();
        long cost = end - start;

        System.out.println("cost:" + cost);

        System.out.println(array[1234]);
        System.out.println(array[125135]);
        System.out.println(array[925135]);
    }
}
