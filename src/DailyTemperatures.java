public class DailyTemperatures {
    public int[] dailyTemperatures(int[] temperatures) {
//        int [] result = new int[temperatures.length];
//        result[result.length-1] = 0;
//        for (int i = 0; i < temperatures.length-1; i++) {
//            int find =0;
//            for (int j = i+1; j < temperatures.length; j++) {
//                if (temperatures[j]>temperatures[i]){
//                    result[i] = find+1;
//                    break;
//                }else{
//                    find++;
//                }
//            }
//        }
//        for (int i = 0; i < result.length; i++) {
//            int i1 = result[i];
//            System.out.println(i1);
//
//        }
//
//        return result;
        int[] r = new int[temperatures.length];
        if(temperatures == null || temperatures.length==0)
            return r;

        for(int i=0; i<temperatures.length; i++) {
            int j=i+1;
            while(j<temperatures.length && temperatures[j]<=temperatures[i]) {
                j++;
            }
            if(j<temperatures.length)
                r[i] = j-i;
        }

        int i=0;
        for(i=temperatures.length-1; i>0; i--) {
            if(temperatures[i] <= temperatures[i-1])
                r[i]=0;
            else break;
        }
        r[i]=0;
        return r;

    }

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
//        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] temperatures = {1,2,3};
        dailyTemperatures.dailyTemperatures(temperatures);

    }
}
