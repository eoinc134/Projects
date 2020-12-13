import java.util.ArrayList;
public class TestBankAccount
{    
     public static void main(String[] args){                   
         ArrayList<BankAccount> accounts = new ArrayList<BankAccount>();
         accounts.add(new SavingsAccount(1, 200)); //create savings account
         accounts.add(new CurrentAccount(2, 1000)); //create current account
         accounts.add(new CurrentAccount(3, 10)); //create current account         
         
         for(BankAccount b: accounts){
             b.setAnnualInterestRate(10);
             b.withdraw(200);
             b.deposit(50);
         }
         
         System.out.println("Accounts:\n" + accounts.toString()); //print accounts        
     }
}

