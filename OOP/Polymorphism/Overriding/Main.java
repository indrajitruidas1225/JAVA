class Person{
    void role(){
        System.out.println("I'm a person");
    }
}

class Father extends Person{
    void role(){
        System.out.println("I'm a father");
    }
}
public class Main {
    public static void main(String[] args){
        Person p = new Father();
        p.role();
    }
}
