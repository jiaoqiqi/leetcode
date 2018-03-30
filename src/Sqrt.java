import static java.lang.Math.abs;

//求平方根
public class Sqrt {
    double sqrtby2(float a)
    {
        if(a <= 0)
            return 0;
        float mid, pre;
        float low=0, high=a;
        mid = (low + high)/2;
        do{
            if(mid*mid > a)
                high = mid;
            else
                low = mid;
            pre = mid;
            mid = (low + high)/2;
        }while(abs(mid-pre) > 0.01);
        return mid;
    }


    double sqrt(int x) {
        if(x <= 0)
            return 0;
        double c = x;
        double old;
        do
        {
            old = c;
            c = (c + x/c)/2;
        }while(abs(old - c) > 0.001);

        return c;
    }

    public static void main(String[] args) {
        Sqrt sqrt = new Sqrt();
        System.out.println(sqrt.sqrt(3));
    }
}
