class Animal{
    void animalSound(){
        System.out.println("Animal makes sound");
    }
}
class Dog extends Animal{
    void animalSound(){
        System.out.println("Dog barks");
    }
}
class Pig extends Animal{
    void animalSound(){
        System.out.println("The pig says wee, wee !");
    }
}
public class Main {
    public static void main(String[] args){
        Animal myAnimal = new Animal();
        Animal myPig = new Pig();
        Animal myDog = new Dog();

        myAnimal.animalSound();
        myPig.animalSound();
        myDog.animalSound();
    }
}
