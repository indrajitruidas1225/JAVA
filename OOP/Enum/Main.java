enum Day{
    Monday, Tuesday, Wednesday
}

public class Main {
    public static void main(String[] args){
        Day today = Day.Tuesday;

        switch(today){
            case Monday:System.out.println("Start of the week!");
            break;
            default:System.out.println("Regular Day");
        }
    }
}
