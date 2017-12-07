public class AddDigits {
    public int addDigits(int num) {
        if (num<10) return num;
        num = num/10+num%10;
        if (!(num<10)){
            num = num/10+ num%10;
            addDigits(num);
        }
        return num;
//        return num==0?0:(num%9==0?9:(num%9));
    }

    public static void main(String[] args) {
        AddDigits addDigits = new AddDigits();
        int num = 99;
        System.out.println(addDigits.addDigits(num));
    }
}
