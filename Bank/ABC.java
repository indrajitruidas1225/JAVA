package Bank;

public class ABC implements CentralBank{
    String name;
    String acc_no;
    String acc_type;
    long balance;

    ABC(String name, String acc_no, String acc_type, long balance){
        this.name = name;
        this.acc_no = acc_no;
        this.acc_type = acc_type;
        this.balance = balance;
    }

    public long getBalance(){
        return this.balance;
    }

    public void withdraw(long amount){
        if(amount > this.balance){
            System.out.println("Account no -"+this.acc_no+"doesn't have sufficient balance !");
        }else if(amount < 0){
            System.out.println("Enter a valid amount");
        }else{
            this.balance -= amount;
            System.out.println(amount+" has been withdrawn successfully from "+this.acc_no);
        }
    }

    public void deposit(long amount){
        this.balance += amount;
        System.out.println("Amount deposited successfully !");
    }

    public void showAccount(){
        System.out.println("UNB Bank account");
        System.out.println("Name of account holder: " + name);  
        System.out.println("Account no.: " + acc_no);  
        System.out.println("Account type: " + acc_type);  
        System.out.println("Balance: " + balance);  
    }

    public boolean search(String acc_no){
        if(acc_no.equals(this.acc_no)){
            showAccount();
            return true;
        }
        return false;
    }
}
