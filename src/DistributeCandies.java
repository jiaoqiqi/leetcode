import java.util.HashSet;
import java.util.Set;

public class DistributeCandies {
    public int distributeCandies(int[] candies) {

        Set<Integer> kinds = new HashSet<>();
        for (int candy : candies) kinds.add(candy);
//        System.out.println(kinds.size());
//        System.out.println(candies.length/2);
        return kinds.size() >= candies.length / 2 ? candies.length / 2 : kinds.size();
    }

    public static void main(String []args){
        int [] candies = {1,1,2,3};
        DistributeCandies distributeCandies = new DistributeCandies();
        System.out.println(distributeCandies.distributeCandies(candies));
    }
}
