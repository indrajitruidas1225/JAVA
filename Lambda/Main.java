import java.util.ArrayList;
public class Main {
    public static void main(String[] args){
        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.add(6);
        numbers.add(9);
        numbers.add(2);
        numbers.add(5);
        numbers.add(6);

        numbers.forEach((n)-> { System.out.println(n); });
    }
}
