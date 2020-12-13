import java.time.LocalDateTime;
import java.util.ArrayList;
public class BankAccount
{
    private String name;
    private int id;
    private double balance;
    private double annualInterestRate = 0;
    private LocalDateTime dateCreated;
    private ArrayList<Transaction> transactions;
    
    public BankAccount(int id, double balance){
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        this.dateCreated = LocalDateTime.now();
        this.transactions = new ArrayList<Transaction>();
    }
     public BankAccount(String name, int id, double balance){
        this.name = name;
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        this.dateCreated = LocalDateTime.now();
        this.transactions = new ArrayList<Transaction>();
    }
    
    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    
    public double getAnnualInterestRate(){
        return annualInterestRate;
    }
    public void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }
    
    public LocalDateTime getDateCreated(){
        return this.dateCreated;
    }
    
    public double getMonthlyInterestRate(){
        return this.annualInterestRate / 12;
    }
    
    public void withdraw(double ammount){
        this.balance -= ammount;
        this.transactions.add(new Transaction('W', ammount, this.balance, "withdraw"));
    }
    public void deposit(double ammount){
        this.balance += ammount;
        this.transactions.add(new Transaction('D', ammount, this.balance, "deposit"));
    }
    
    public String toString(){
        return "\n\nID: " + this.id + ", Balance: €" + this.balance + ", Annual Interest Rate: " + this.annualInterestRate + "%, Date Created: " + this.dateCreated + "\n" + transactions.toString();
    }
}
