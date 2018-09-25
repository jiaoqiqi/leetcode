package 笔试;

import java.util.Scanner;

public class LuoxuanJuzhen {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int x = in.nextInt();
        int y = in.nextInt();
        int[][] matrix = spiralMatrix(n);
        System.out.println(matrix[x-1][y-1]);

    }

    public static int[][] spiralMatrix(int n){
        int circleMatrix[][] = new int[n][n];
        for(int num = 1, x=0,y=0,xDir = 1,yDir = 0; num <= n*n ; num++){

            circleMatrix[x][y] = num;
            if(x + xDir <0 || y + yDir<0 || x + xDir == n || y + yDir == n || circleMatrix[x + xDir][y + yDir] !=0){//如果到边界了就换方向
                if(xDir != 0){
                    yDir = xDir;
                    xDir = 0;
                }else{
                    xDir = -yDir;
                    yDir = 0;
                }
            }
            x += xDir;

            y += yDir;

        }
        return circleMatrix;

    }
}
