public class MethodOne {
    static void myMethod(){
        System.out.println("I got called");
    }
    public static void main(String[] args){
        myMethod();
        myMethod();
    }
}
