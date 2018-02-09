public class RangeAdditionII {
    public int maxCount(int m, int n, int[][] ops) {
        int rowMin = m;
        int colMin = n;
        for (int[] pair : ops) {
            rowMin = Math.min(rowMin, pair[0]);
            colMin = Math.min(colMin, pair[1]);
        }
        return rowMin * colMin;
    }
}
