import java.util.HashMap;
//[1,1,2] = 3+1-1+2
//[10,10,10] = 3+10-1-1
//[1,0,1,0,0] = 5+1-1
//首先数组的长度代表存在的兔子,从第一个开始 先加上跟他不一样的,后面遇到跟前面一样的总数量再减一

public class RabbitsinForest {
    public int numRabbits(int[] answers) {
        if(answers.length == 0) return 0;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int sum = 0;

        for(int i : answers){
            if(i == 0 ){
                sum += 1;
                continue;
            }
            if(!map.containsKey(i)){
                //If we haven't accounted for this rabbit color then account for the one telling us
                // as well as the one that rabbit says is that color.
                map.put(i, 0);
                sum += (i + 1);

            }else{
                map.put(i, map.get(i) + 1);
                //if there are k of each color then they are all present, remove them to allow the change to account for others.
                if(map.get(i) == i){
                    map.remove(i);
                }
            }

        }
        return sum;
    }
    public static void main(String[] args) {
        RabbitsinForest rabbitsinForest = new RabbitsinForest();
        int[] answers = {1,1,2};
        System.out.println(rabbitsinForest.numRabbits(answers));
    }
}
