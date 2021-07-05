
public class Password
{
   private int minLen; //min length
   private int maxLen; // max length
   private String specialChars; //symbols
   private String lowerCase; //lowercase characters
   private String upperCase; //uppercase characters
   private String digits; //numbers
   
   public Password(){
       minLen = 6; //set min length to 6
       maxLen = 14; //set max length to 14
       specialChars = "!$_-#";
       lowerCase = "abcdefghijklmnopqrstuvwxyz";
       upperCase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
       digits = "0123456789";
   }
   
   public String generate(int preferredLength){
       String password = "";
       String alphabet = lowerCase + upperCase + digits + specialChars;
       int pos, i;
       boolean validated = false;
       
       if(preferredLength < minLen){ //check if preferred length is less than 6
           preferredLength = minLen; //if so set preferred length to 6
       }
       if(preferredLength > maxLen){ //check if preferred length is more than 14
           preferredLength = maxLen; //if so set preferred length to 14
       }
       
       while(validated == false){ //continue generating passwords until a valid password is validated
           for(i = 0 ; i < preferredLength ; i++) {
               pos = (int) (Math.random() * alphabet.length()) ; //choose random character from upper, lower, numbers and special chars
               password = password + alphabet.charAt(pos) ; //add chosen character to password
           }
           
           if(validate(password)){ //if password is valid end while loop
               validated = true;
           } else { //else delete password
               password = ""; //resets password 
           }
       }
       
       return password; //return the generated password
   }
   
   public boolean validate(String password){
       boolean decision = false; //is password valid
       boolean containsUpper = false; //does password contain uppercase character   
       boolean containsLower = false; //does password contain lowercase character
       boolean containsDigit = false; //does password contain number
       boolean containsChar = false; //does password contain a symbol
       boolean validLength = false; //is password between 6 and 14 characters long
       
       for(int i = 0; i < password.length(); i++){ //loop through each character in the password
           if(upperCase.indexOf(password.charAt(i)) > -1){ //check if character is uppercase
               containsUpper = true; //if so password contains uppercase
           }
           if(lowerCase.indexOf(password.charAt(i)) > -1){ //check if charater is lowercase
               containsLower = true; //if so password contains lowercase
           }
           if(digits.indexOf(password.charAt(i)) > -1){//check if charatcer is a number
               containsDigit = true; //if so password contains nunmber
           }
           if(specialChars.indexOf(password.charAt(i)) > -1){//check if charater is a symbol
               containsChar = true; //if so password contains symbol
           }
       }
       
       if(password.length() >= 6 && password.length() <= 14){
           validLength = true; //validate is password is between 6 and 14 characters
       }
       
       if(containsUpper && containsLower && containsDigit && containsChar && validLength){
           decision = true; //validate password if it contains an upper, lower, number, symbol and is between 6-14 characters
       }
       
       return decision; //return true if all conditions met
   }
}
