public class ProgramTwo {
    final int x = 10;
    public static void main(String[] args){
        ProgramTwo myObj = new ProgramTwo();
        myObj.x = 25; //will generate error
        System.out.println(myObj.x);
    }
}
