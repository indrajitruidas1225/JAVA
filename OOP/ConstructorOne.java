public class ConstructorOne {
    int birthYear;
    String name;

    public ConstructorOne(int year, String myName){
        birthYear = year;
        name = myName;
    }

    public static void main(String[] args){
        ConstructorOne myObj = new ConstructorOne(2002,"Indrajit" );
        System.out.println(myObj.name + ' ' + myObj.birthYear);
    }
}
