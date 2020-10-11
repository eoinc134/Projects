import java.util.Scanner;
public class odds
{
    public void odds(){
        Scanner input = new Scanner(System.in);
        System.out.println("odds man: ");
        int odds = input.nextInt();
        
        int comp = (int)(Math.random() * odds) + 1;
        System.out.println("3 2 1...");
        int player = input.nextInt();
        
        System.out.println("Your Number: " + player);
        System.out.println("My Number: " + comp);
        if(player == comp){
            System.out.println("YOU LOST!");
        } else {
            System.out.println("YOU WON!");
        }
    }
}
