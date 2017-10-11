public class ComplexMultiplyNumber {
    public String complexNumberMultiply(String a, String b) {
        String x[] = a.split("\\+|i");
        String y[] = b.split("\\+|i");
        int a_real = Integer.parseInt(x[0]);
        int a_false = Integer.parseInt(x[1]);
        int b_real = Integer.parseInt(y[0]);
        int b_false = Integer.parseInt(y[1]);
        System.out.println(a_false);

        return (a_real * b_real + a_false * b_false) + "+" + (a_real * b_false - a_false * b_real) + "i";
    }

    public static void main(String []args){
        ComplexMultiplyNumber  multiply = new ComplexMultiplyNumber();
        System.out.println(multiply.complexNumberMultiply("1+-1i", "1+-1i"));
    }

}




