public class MethodOverloading {
    static int plusMethod(int x, int y){
        return x + y;
    }
    static double plusMethod(double x, double y){
        return x + y;
    }

    public static void main(String[] args){
        int myNum1 = plusMethod(5,6);
        double myNum2 = plusMethod(5.6, 8.9);

        System.out.println(myNum1);
        System.out.println(myNum2);
    }
}
