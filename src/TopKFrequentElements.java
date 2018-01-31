import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        List<Integer> result = new ArrayList<>();
        List<Integer>[] bucket = new List[nums.length + 1];
        Map<Integer, Integer> frequencyMap = new HashMap<Integer, Integer>();

        for (int num : nums){
            frequencyMap.put(num,frequencyMap.getOrDefault(num,0)+1);
        }

        System.out.println(frequencyMap);

        for (int key : frequencyMap.keySet()){
            int frequency = frequencyMap.get(key);
            System.out.println(frequency);
            if (bucket[frequency] == null){
                    bucket[frequency] = new ArrayList<>();

            }
            bucket[frequency].add(key);

        }
//
        for (int i = 0; i < bucket.length; i++) {
            List<Integer> integers = bucket[i];
            System.out.println(integers);

        }

        for (int pos = bucket.length - 1; pos >= 0 && result.size() < k; pos--) {
            if (bucket[pos] != null) {
                result.addAll(bucket[pos]);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        TopKFrequentElements topKFrequentElements = new TopKFrequentElements();
        int [] nums = {5,5,5,6,7,6};
        int k = 2;
        System.out.println(topKFrequentElements.topKFrequent(nums,k));
    }
}
