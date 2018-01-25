public class PrimeNumberofSetBits {
    public int countPrimeSetBits(int L, int R) {
        int result =0;
        for (int i = L; i <= R; i++) {
            if (isPrime(getBits(i))){
                result++;
            }
        }
        System.out.println(result);
        return  result;

    }

    public  int getBits(int a){
        int bits =0;
        String b = Integer.toBinaryString(a);
        for (int i = 0; i < b.length(); i++) {
            if ((b.charAt(i) == '1')){
                bits++;
            }
        }
        return bits;

    }

    public boolean isPrime(int n){
        if(n < 2) return false;

        for(int i = 2; i < n; ++i)

            if(n%i == 0) return false;

        return true;


    }

    public static void main(String[] args) {
        PrimeNumberofSetBits primeNumberofSetBits = new PrimeNumberofSetBits();
//        primeNumberofSetBits.getBits(3);
        primeNumberofSetBits.countPrimeSetBits(6,10);
//        int a = primeNumberofSetBits.getBits(8);
//        System.out.println(a);
//        System.out.println(primeNumberofSetBits.isPrime(1));
    }
}
