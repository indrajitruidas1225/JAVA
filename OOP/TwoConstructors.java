public class TwoConstructors {
    int age;
    String name;
    public TwoConstructors(String name){
        this(22, name);
        System.out.println("This is from single parameter constructor, value is");
    }
    public TwoConstructors(int first, String second){
        this.age = first;
        this.name = second;
    }
    public void PrintInfo(){
        System.out.println(name + ' ' +age);
    }
    public static void main(String[] args){
        TwoConstructors person1 = new TwoConstructors("Indrajit");
        TwoConstructors person2 = new TwoConstructors(23,"John");
        person1.PrintInfo();
        person2.PrintInfo();
    }
}
