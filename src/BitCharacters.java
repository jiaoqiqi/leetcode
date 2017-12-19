public class BitCharacters {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        int i = 0;
        while (i < n - 1) {
            if (bits[i] == 0) i++;
            else i += 2;
        }
        return i == n - 1;
    }

    public static void main(String[] args) {
        BitCharacters bitCharacters = new BitCharacters();
        int[] bits = {1, 1, 1, 0};
        System.out.println(bitCharacters.isOneBitCharacter(bits));
    }
}
