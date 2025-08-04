public class ProgramOne{
    int x = 10;
    public static void main(String[] args){
        ProgramOne myObj = new ProgramOne();
        myObj.x = 25; //it overrided the value of x
        System.out.println(myObj.x);
    }
}