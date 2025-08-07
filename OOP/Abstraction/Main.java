abstract class Animal{
    private String name;

    Animal(String name){
        this.name = name;
    }
    public abstract void makeSound();

    public String getName(){
        return name;
    }
}

class Dog extends Animal{
    Dog(String name){
        super(name);
    }
    public void makeSound(){
        System.out.println(getName()+" barks");
    }
}

class Cat extends Animal{
    Cat(String name){
        super(name);
    }
    public void makeSound(){
        System.out.println(getName()+" meows");
    }
}
public class Main {
    public static void main(String[] args){
        Animal myDog = new Dog("ABC");
        Animal myCat = new Cat("XYZ");

        myDog.makeSound();
        myCat.makeSound();
    }
}
