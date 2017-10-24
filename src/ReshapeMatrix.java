//https://leetcode.com/problems/reshape-the-matrix/description/

public class ReshapeMatrix {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int len = nums.length;
        int clen = nums[0].length;
        if (r * c > len * clen || r * c < len * clen) {
            return nums;
        }

        int[] arr = new int[len*clen];
        int index = 0;
        for(int i = 0;i < len;i++){
            for(int j = 0;j < clen;j++){
                arr[index++] = nums[i][j];
            }
        }

        int[][] result = new int[r][c];
        int newlen =0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = arr[newlen++];

            }

        }
        return result;
    }

    public static void main(String[] args) {
        ReshapeMatrix reshapeMatrix = new ReshapeMatrix();
        int[][] nums = {{1, 2}, {3, 4}};
        int r = 1;
        int c = 4;

        int[][] result = reshapeMatrix.matrixReshape(nums, r, c);

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                System.out.println(result[i][j]);

            }

        }

    }
}
