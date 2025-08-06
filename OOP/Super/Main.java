class Animal{
    int legs = 4;
    Animal(){
        System.out.println("Animal is created.");
    }
    static void AnimalSound(){
        System.out.println("Animal makes sound");
    }
}
class Dog extends Animal{
    Dog(){
        super();
        super.AnimalSound();
        System.out.println("Animal has"+' '+super.legs+"legs.");
    }
}
public class Main {
    public static void main(String[] args){
        Dog obj = new Dog();
    }
}
