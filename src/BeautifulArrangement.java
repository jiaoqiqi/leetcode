//https://leetcode.com/problems/beautiful-arrangement-ii/description/


public class BeautifulArrangement {
    public int[] constructArray(int n, int k) {

        if(k>=n) return null;
        int[] arr = new int[n];
        int i = 0, small = 1, large = n;
        while(i<k){
            arr[i++] = small++;
            if(i<k) arr[i++] = large--;
        }
        if(k%2 == 0){
            while(i<arr.length) arr[i++] = large--;
        } else {
            while(i<arr.length) arr[i++] = small++;
        }

        for (int j = 0; j < arr.length; j++) {
            int i1 = arr[j];
            System.out.print(i1);

        }
        return arr;
    }

    public static void main(String[] args) {
        BeautifulArrangement beautifulArrangement = new BeautifulArrangement();
        beautifulArrangement.constructArray(5,4);


    }
}
