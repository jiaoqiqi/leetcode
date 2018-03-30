package 网络编程;

import 网络编程.RuntimeData;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class Ex1_3
{

    public static void main(String args[])
    {
        int k = 2;
        @SuppressWarnings("unused")
        long m = 0, n = 0;
        long start = System.currentTimeMillis();
        m = thread(k, 1);
        n = thread(k, 2);
        long end = System.currentTimeMillis();
        long cost = end - start;
        System.out.print("cost:" + cost);

    }

    public static int jia(char str[], int m)
    {

        char jia[] =
        { '贾', '宝', '玉' };

        for(int i = 0; i < jia.length; i++)
        {
            if(str[i] != jia[i])
            {
                break;
            }
            if(i == jia.length - 1)
            {
                m++;

            }
        }

        return m;

    }

    public static int lin(char str[], int n)
    {
        char lin[] =
        { '林', '黛', '玉' };
        for(int i = 0; i < lin.length; i++)
        {
            if(str[i] != lin[i])
            {
                break;
            }
            if(i == lin.length - 1)
                n++;
        }
        return n;

    }

    public static long thread(int k, int l)
    {
        char str[] = new char[3];
        int i = 0;
        char list[] = new char[10000000];
        File f = new File("E:\\Dev-Cpp\\test\\a.txt");
        Reader reader = null;
        try
        {

            reader = new InputStreamReader(new FileInputStream(f));
            int tempchar;
            while((tempchar = reader.read()) != -1)
            {
                list[i] = (char) tempchar;
                i++;
            }
            reader.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        int threadcount = i / k;
        // 平均每个线程计算的数目
        // System.out.print(threadcount + "\n");
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
                    int m = 0;
                    start = index * threadcount;
                    end = start + threadcount;
                    // System.out.print(start + " " + end + "\n");
                    for(int v = start; v < end - 2; v++)
                    {
                        for(int y = 0; y < 3; y++)
                        {
                            str[y] = list[v + y];
                        }
                        if(l == 1)
                        {
                            m = jia(str, m);
                        }
                        else
                        {
                            m = lin(str, m);
                        }

                    }
                    synchronized(rData)
                    {
                        rData.sum += m;
                        // System.out.print(m + "\n");
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
}
