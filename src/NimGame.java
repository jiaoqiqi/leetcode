//https://leetcode.com/problems/nim-game/description/
//当n∈[1,3]时，先手必胜。
//当n == 4时，无论先手第一轮如何选取，下一轮都会转化为n∈[1,3]的情形，此时先手必负。
// 当n∈[5,7]时，先手必胜，先手分别通过取走[1,3]颗石头，可将状态转化为n == 4时的情形，此时后手必负。
// 当n == 8时，无论先手第一轮如何选取，下一轮都会转化为n∈[5,7]的情形，此时先手必负。
//以此类推
//当n % 4 != 0时，先手必胜；否则先手必负。
public class NimGame {
    public boolean canWinNim(int n) {
        if (n%4==0){
            return false;
        }
        else{
            return true;
        }
    }
    public static void main(String []args){
        int n=4;
        NimGame nimGame = new NimGame();
        System.out.println(nimGame.canWinNim(n));
    }
}
