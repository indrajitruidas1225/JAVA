class Vehicle {
    protected String brand = "Ford";
    public void honk(){
        System.out.println("Tut, tut !");
    }
}

public class Inheritance extends Vehicle{
    private String modelName = "Mustang";
    public static void main(String[] args){
        Inheritance myCar = new Inheritance();
        myCar.honk();

        System.out.println(myCar.brand+' '+myCar.modelName);
    }
}
