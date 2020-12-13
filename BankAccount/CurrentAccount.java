import java.util.ArrayList;
public class CurrentAccount extends BankAccount
{
    private double overdraftLimit;
    private ArrayList<Transaction> transactions;
       
    public CurrentAccount(int id, double balance){
        super(id, balance);
        this.overdraftLimit = 100;
        this.transactions = new ArrayList<Transaction>();
    }
    public CurrentAccount(int id, double balance, double overDraftLimit){
        super(id, balance);
        this.overdraftLimit = overdraftLimit;
        this.transactions = new ArrayList<Transaction>();
    }
    
    public CurrentAccount(String name, int id, double balance){
        super(name, id, balance);
        this.overdraftLimit = 100;
    }
    public CurrentAccount(String name, int id, double balance, double overDraftLimit){
        super(name, id, balance);
        this.overdraftLimit = overdraftLimit;
    }
    
    @Override
    public void withdraw(double ammount){
        double bal = getBalance();
        if(ammount <= bal + overdraftLimit){
            setBalance(bal - ammount);
            this.transactions.add(new Transaction('W', ammount, getBalance(), "withdraw"));
        } else {
            System.out.println("Overdraft Limit Reached for " + getId());
        }
    }
    @Override
    public void deposit(double ammount){
        setBalance(getBalance() + ammount);
        this.transactions.add(new Transaction('D', ammount, getBalance(), "deposit"));
    }
    
    public String toString(){       
        return "\n\nID: " + getId() + ", Balance: €" + getBalance() + ", Annual Interest Rate: " + getAnnualInterestRate() + "%, Date Created: " + getDateCreated() + "\n" + transactions.toString();
    }
}
