//求平方根
public class Sqrt {
    double sqrtby2(double a)
    {
        if(a <= 0)
            return 0;
        double mid, pre;
        double low=0, high=a;
        mid = (low + high)/2;
        do{
            if(mid*mid > a)
                high = mid;
            else
                low = mid;
            pre = mid;
            mid = (low + high)/2;
        }while(Math.abs(mid-pre) > 0.0000001);
        return mid;
    }

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.sqrtby2(2));
    }
}
