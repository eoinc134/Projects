import java.time.LocalDateTime;
public class Transaction
{
    private LocalDateTime date;
    private char type;
    private double ammount;
    private double balance;
    private String description;
    
    public Transaction(char type, double ammount, double balance, String description){
        this.type = type;
        this.ammount = ammount;
        this.balance = balance;
        this.description = description;
    }
    
    public String toString(){
        return "\nType: " + this.type + ", Ammount: " + this.ammount + ", Balance: " + this.balance + ", Desciption: " + this.description;
    }
}
