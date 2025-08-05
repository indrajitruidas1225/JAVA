public class StaticPublic{
    static void myStaticMethod(){
        System.out.println("Static methods can be called without creating objects");
    }

    public void myPublicMethod(){
        System.err.println("Public methods can't be called without creating objects");
    }

    public static void main(String[] args){
        myStaticMethod();
        //myPublicMethod(); generates error
        StaticPublic obj = new StaticPublic();
        obj.myPublicMethod();
    }
}