
public class Main {
    public static void main(String[] args){
        try{
            int[] myNumbers = {3, 5, 7};
            System.out.println(myNumbers[10]);
        }catch(Exception e){
            System.out.println("Something is wrong");
        }finally{
            System.out.println("Process completed");
        }
    }
}