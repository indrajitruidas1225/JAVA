class OuterClass{
    int x = 10;
    class InnerClass{
        int y = 5;
        int getX() {
            return x;
        }
    }
    private class NewInnerClass{
        int y = 5;
    }
    static class StaticInnerClass{
        int k = 9;
    }
}
public class Main {
    public static void main(String[] args){
        OuterClass myOuter = new OuterClass();
        OuterClass.InnerClass myInner = myOuter.new InnerClass();
        System.out.println(myOuter.x + myInner.y);


        //OuterClass.privateInnerClass = myOuter.new NewInnerClass(); error: OuterClass.NewInnerClass has private access in OuterClass
        OuterClass.StaticInnerClass myStaticInnerClass = new OuterClass.StaticInnerClass();
        System.out.println(myStaticInnerClass.k);
        System.out.println(myInner.getX());
    }
}
