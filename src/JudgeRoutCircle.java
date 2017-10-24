//https://leetcode.com/problems/judge-route-circle/

public class JudgeRoutCircle {
    public boolean judgeCircle(String moves) {
        boolean res=false;
        int updown = 0;
        int leftright =0;
        String[] splitMoves = moves.split("");
        for (int i=0 ; i<splitMoves.length ; i++){
            switch (splitMoves[i]){
                case "U":updown++;break;
                case "D":updown--;break;
                case "L":leftright++;break;
                case "R":leftright--;break;
            }
        }
        if (updown==0 && leftright==0){
            res=true;
        }
        return res;

    }

    public static void main(String []args){
        String b = "LDRRLRUULR";
        String a = "UD";
        JudgeRoutCircle judge  = new JudgeRoutCircle();
        System.out.println(judge.judgeCircle(b));
    }
}


