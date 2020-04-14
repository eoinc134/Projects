public class Test
{
   public static void main(){
        final long MILLISECONDS_IN_A_DAY = 24*60*60*1000 ;
        final long SECONDS_IN_AN_HOUR = 60*60;
        long secondsSinceMidnight = 0;
        long hour = 0, minute = 0, second = 0;
        secondsSinceMidnight = (System.currentTimeMillis() % 
            MILLISECONDS_IN_A_DAY) / 1000;
        hour = secondsSinceMidnight / SECONDS_IN_AN_HOUR;
        minute = (secondsSinceMidnight % SECONDS_IN_AN_HOUR ) / 60;
        second = secondsSinceMidnight % 60;
        System.out.println(hour + ":" + minute + ":" + second);
        
   }
   public boolean isVowel(char ch){
     return "aeiouAEIOU".indexOf(ch) != -1;  
    }
}