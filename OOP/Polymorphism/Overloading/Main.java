class Helper{
    static int Multiply(int a, int b){
        return a*b;
    }

    static double Multiply(double a, double b){
        return a*b;
    }
}
public class Main {
    public static void main(String[] args){
        System.out.println(Helper.Multiply(5, 8));
        System.out.println(Helper.Multiply(5.7, 9.40));
    }
}
