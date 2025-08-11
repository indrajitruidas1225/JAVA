class Box<T>{
    T value;
    void set(T value){
        this.value = value;
    }
    T get(){
        return this.value;
    }
}

public class Main {
    public static void main(String[] args){
        Box<String> StringBox = new Box<>();
        Box<Integer> IntegerBox = new Box<>();

        StringBox.set("Indra");
        System.out.println(StringBox.get());

        IntegerBox.set(5);
        System.out.println(IntegerBox.get());
    }
}
