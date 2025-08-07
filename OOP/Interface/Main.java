interface Animal{
    public void animalSound();
    public void sleep();
}

interface Properties{
    int leg = 4;
    public void educated();
}

class Dog implements Animal, Properties{
    public void animalSound(){
        System.out.println("Dog barks");
    }
    public void sleep(){
        System.out.println("Dog sleeps");
    }
    public void educated(){
        System.out.println("Dog is not educated");
    }
}

class Cat implements Animal, Properties{

    public void animalSound(){
        System.out.println("Cat meows");
    }
    public void sleep(){
        System.out.println("Cat sleeps");
    }
    public void educated(){
        System.out.println("Cat is not educated");
    }
}
public class Main {
    public static void main(String[] args){
        Dog myDog = new Dog();
        myDog.animalSound();
        myDog.educated();
        System.out.println(Dog.leg);
    }
}
