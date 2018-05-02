public class CouplesHoldingHands {
    public int minSwapsCouples(int[] row) {
        int change = 0;
        if (row[0] > row[1]) {
            reverse(row);
        }
//        for (int i = 0; i < row.length-1; i+=2) {
        int i = 0;
        while (i < row.length - 2) {
            if (row[i + 1] == row[i] + 1 || row[i + 1] == row[i] - 1) {
                i += 2;
            } else {
                int indexOfFlower = index(row, row[i] + 1);
                exchange(row, i + 1, indexOfFlower);
                change++;
                i += 2;
            }
        }
//        }

        return change;

    }


    public int index(int[] arr, int n) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == n) {
                index = i;
                break;
            }
        }
        return index;
    }

    public void exchange(int[] arr, int a, int b) {
        int tag = arr[a];
        arr[a] = arr[b];
        arr[b] = tag;
    }

    public void reverse(int[] validData) {
        for (int i = 0; i < validData.length / 2; i++) {
            int temp = validData[i];
            validData[i] = validData[validData.length - i - 1];
            validData[validData.length - i - 1] = temp;
        }
    }

//    public void pint(int []arr){
//        for (int i = 0; i < arr.length; i++) {
//            int i1 = arr[i];
//            System.out.print(i1);
//
//        }
//    }

    public static void main(String[] args) {
//        int[] row = {3,2,0,1};
//        int[] row = {5,3,4,2,1,0};
        int[] row = {5, 4, 2, 6, 3, 1, 0, 7};
        CouplesHoldingHands couplesHoldingHands = new CouplesHoldingHands();
        System.out.println(couplesHoldingHands.minSwapsCouples(row));

    }
}
