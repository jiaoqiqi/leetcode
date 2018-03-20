package 网络编程;

import java.util.Scanner;
public class PI {
    static double MontePI(int n) {
        double PI;
        double x, y;
        int i, sum;
        sum = 0;
        for (i = 1; i < n; i++) {
            x = Math.random();
            y = Math.random();
            if ((x * x + y * y) <= 1) {
                sum++;
            }
        }
        PI = 4.0 * sum / n;
        return PI;
    }
    public static void main(String[] args) {
        int n;
        double PI;
        System.out.println("蒙特卡洛概率算法计算圆周率:");
        Scanner input = new Scanner(System.in);
        System.out.println("输入点的数量：");
        n = input.nextInt();
        PI = MontePI(n);
        System.out.println("PI="+PI);
    }
}
