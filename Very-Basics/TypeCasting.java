public class TypeCasting {
    public static void main(String[] args){
        int myInt = 9;
        double myDouble = myInt; //Widening Casting -> Automatic Casting : 

        double num = 9.876d;
        int new_num = (int)num; // Narrowing casting -> Manual Casting;

        System.out.println(myDouble);
        System.out.println(new_num);

    }
}
