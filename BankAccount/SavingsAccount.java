import java.util.ArrayList;
public class SavingsAccount extends BankAccount
{    
    private ArrayList<Transaction> transactions;
    
    public SavingsAccount(int id, double balance){
        super(id, balance);
        this.transactions = new ArrayList<Transaction>();
    }
    public SavingsAccount(String name, int id, double balance){
        super(name, id, balance);
        this.transactions = new ArrayList<Transaction>();
    }
    
    @Override
    public void withdraw(double ammount){
        double bal = getBalance();
        if(bal >= ammount && ammount >= 0){
            setBalance(bal - ammount);
            this.transactions.add(new Transaction('W', ammount, getBalance(), "withdraw"));
        } else {
            System.out.print(getId() + ": Not enough money in account");
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
