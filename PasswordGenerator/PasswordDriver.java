
public class PasswordDriver
{
   //Name: David Barrett
   //ID Number: 19264933
   //Phone Number: 087 680 0893
   
   public static void main(String[] args){
       Password dispenser = new Password();
       
       System.out.println("Generated 15 character password...");
       System.out.println( dispenser.generate(15) ); //too long, should generate password length 14
       System.out.println("Generated 10 character password...");
       System.out.println( dispenser.generate(10) ); //generate password length 10
       System.out.println("Generated 6 character password...");
       System.out.println( dispenser.generate(6) ); //generate password length 6
       System.out.println("Generated 2 character password...");
       System.out.println( dispenser.generate(2) ); //too short, should generate password length 6
       System.out.println("Generated -3 character password...");
       System.out.println( dispenser.generate(-3) ); //cant be negative, should generate password length 6
       
       System.out.println("Is 'cs4141_java' a valid password?");
       System.out.println( dispenser.validate("cs4141_java") ); //no uppercase, not valid
       System.out.println("Is 'CS4141-JAVA' a valid password?");
       System.out.println( dispenser.validate("CS4141-JAVA") ); //no lowercase, not valid
       System.out.println("Is 'PassWord!' a valid password?");
       System.out.println( dispenser.validate("PassWord!") ); //no number, not valid
       System.out.println("Is 'Pa55W0rd' a valid password?");
       System.out.println( dispenser.validate("Pa55W0rd") ); //no symbol, not valid
       
       System.out.println("Is '#12Ab' a valid password?");
       System.out.println( dispenser.validate("#12Ab") ); //too short, not valid
       System.out.println("Is 'LM121_Computer-$cience' a valid password?");
       System.out.println( dispenser.validate("LM121_Computer-$cience") ); //too long, not valid
       
       System.out.println("Is 'Va1id!' a valid password?");
       System.out.println( dispenser.validate("Va1id!") ); //valid password
       
       String aPassword = dispenser.generate(9); //generates random length 9 password
       System.out.println("Is " + aPassword + " valid?");
       System.out.println( dispenser.validate(aPassword) ); //validates that the generated password is valid
   }
}
