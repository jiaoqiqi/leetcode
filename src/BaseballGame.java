//https://leetcode.com/problems/baseball-game/description/

import java.util.LinkedList;

public class BaseballGame {
    public int calPoints(String[] ops) {
        int sum = 0;
        LinkedList<Integer> list = new LinkedList<>();
        for (String op : ops) {
            if (op.equals("C")) {
                sum -= list.removeLast();
            }
            else if (op.equals("D")) {
                list.add(list.peekLast() * 2);
                sum += list.peekLast();
            }
            else if (op.equals("+")) {
                list.add(list.peekLast() + list.get(list.size() - 2));
                sum += list.peekLast();
            }
            else {
                list.add(Integer.parseInt(op));
                sum += list.peekLast();
            }
        }
        return sum;
    }

    public static void main(String []args){
        String [] ops = {"5","2","C","D","+"};
        BaseballGame baseballGame = new BaseballGame();
        System.out.println(baseballGame.calPoints(ops));
    }
}
