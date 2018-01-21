import java.util.HashMap;

public class FindAnagramMappings {
    public int[] anagramMappings(int[] A, int[] B) {
        int l = A.length;
        int[] res = new int[l];
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<l;i++){
            map.put(B[i],i);
        }
        for(int i=0;i<l;i++){
            res[i] = map.get(A[i]);
        }

        return res;
    }
}
