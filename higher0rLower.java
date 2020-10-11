import java.util.Scanner;
public class higher0rLower
{
    public void higherOrLower(){        
        Scanner input = new Scanner(System.in);
        
        int card1 = (int)(Math.random() * 13 + 1);
        if(card1 < 11){
           System.out.println("CARD: " + card1);   
        } else if(card1 == 11){
           System.out.println("CARD: JACK");  
        } else if(card1 == 12){
           System.out.println("CARD: QUEEN");  
        } else if(card1 == 13){
           System.out.println("CARD: KING");  
        }
        
        int level = 5;
        while(level > 0){
            System.out.println("Higher or Lower? [0: Lower; 1: Higher]");
            int choice = input.nextInt();
            int card2 = (int)(Math.random() * 13 + 1);
            
            if(card2 < 11){
                System.out.println("CARD: " + card2);   
            } else if(card2 == 11){
                System.out.println("CARD: JACK");  
            } else if(card2 == 12){
                System.out.println("CARD: QUEEN");  
            } else if(card1 == 13){
                System.out.println("CARD: KING");  
            }
            
            if(choice == 0){
                if(card2 > card1){
                    System.out.println("Higher! Start Again");
                    level = 5;
                } else if(card2 == card1){
                    System.out.println("Same! Try Again");
                } else if(card2  < card1){
                    System.out.println("Lower! Keep Going");
                    level--;
                }
            } else {
                if(card2 > card1){
                    System.out.println("Higher! Keep Going");
                    level--;
                } else if(card2 == card1){
                    System.out.println("Same! Try Again");
                } else if(card2  < card1){
                    System.out.println("Lower! Start Again");
                    level = 5;
                }
            }
            
            card1 = card2;
        }
        
        System.out.println("5 in a row! YOU WIN!");
    }
}
