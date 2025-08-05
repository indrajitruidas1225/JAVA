class Main {
    private String name;

    public String getName(){
        return name;
    }
    public void setName(String newName){
        this.name = newName;
    }
}

public class Encapsulation{
    public static void main(String[] args){
        Main obj = new Main();
        // obj.name = "Indra"; gives error
        // System.out.println(obj.name); gives error

        obj.setName("Indrajit");
        System.out.println(obj.getName());
    }
}