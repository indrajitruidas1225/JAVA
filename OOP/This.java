public class This {
    int x;
    public This(int x){
        this.x = x;
    }
    public static void main(String[] args){
        This obj = new This(5);
        System.out.println(obj.x);
    }
}
