
public class OddOrEven
{
   public String enterNumber(int number){
       String output;
       
       if(number % 2 == 0){
           output = "Even";
       } else {
           output = "Odd";
       }        
        
       return output;
   }
}
