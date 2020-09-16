import java.lang.Math;
public class RockPaperScissors
{
    public void RPS(String input){                
        input = input.toLowerCase();
        int inputInt = 10; //needs a staring value incase of invalid input
        int computerInt = (int)(Math.random() * 3);//randNum between 0-2
        String computer;
        String outcome = "";
        
        if(input == "rock"){
            inputInt = 0;//rock = 0
        } else if(input == "paper"){
            inputInt = 1;//paper = 1
        } else if(input == "scissors"){
            inputInt = 2;//scissors = 2
        } else {
            input = "Invalid Input"; //in case of another input
        }
        
        if(computerInt == 0){
            computer = "rock";
        } else if(computerInt == 1){
            computer = "paper";
        } else {
            computer = "scissors";
        }
        
        if(inputInt == computerInt){
            outcome = "DRAW"; //same number = draw
        } else if(inputInt + 1 == computerInt || inputInt - 2 == computerInt){
            outcome = "LOSE"; // lose to higher move or ""2 lower""
        } else if(inputInt + 2 == computerInt || inputInt - 1 == computerInt){
            outcome = "WIN"; // win against lower move or "2 higher"
        }
        
        System.out.println("Player: " + input); //player move
        System.out.println("Computer: " + computer); //computer move
        System.out.println(outcome); //outcome
    }
}