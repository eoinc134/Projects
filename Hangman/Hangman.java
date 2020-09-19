import java.util.ArrayList ;
import java.util.Arrays;
import java.util.Collections;
import java.io.* ;
public class Hangman
{    
    private String chosenWord;
    private int length;
    private int lives;
    private char[] guessed;
    
    private ArrayList<String> loadWordFromFile(String filename) {
        try {
            FileReader aFileReader = new FileReader(filename);
            BufferedReader aBufferReader = new BufferedReader(aFileReader);
            String aWord;
            ArrayList<String> words = new ArrayList<String>();
            aWord = aBufferReader.readLine();
            while(aWord != null){
                words.add(aWord.toUpperCase());
                aWord = aBufferReader.readLine();
            }
            aBufferReader.close();
            aFileReader.close();
            return words ;
        }
        catch(IOException x) {
            return null ;
        }
    }
    
    public void startGame(String wordFile){
        lives = 5;        
        ArrayList<String> chosen = loadWordFromFile(wordFile);
        int pos = (int)(Math.random() * chosen.size());
        chosenWord = chosen.get(pos);        
        length = chosenWord.length();
        char[] guessed = new char[length];
        for(int i = 0; i < length; i++){
            guessed[i] = 0;
        }
        
        System.out.println("Length: " + length);
        System.out.println("Lives: " + lives);
        System.out.println("GUESS A LETTER");
        System.out.println("");
    }    
    
    public int guessLetter(char letter){        
        int count = 0;      
        for(int i = 0; i < length; i++){            
            if(letter == chosenWord.charAt(i)){
               guessed[i] = letter;
               count++;              
            } 
            System.out.print(guessed[i]);
        }
        System.out.println("");
        System.out.println("GUESSED: " + letter);
        
        if(count == 0){
            lives--;
        }
        System.out.println("Lives Remaining: " + lives);
        System.out.println("");
        
        if(lives == 0){
            System.out.println("YOU LOSE");
            System.out.println("The word was " + chosenWord);
            System.out.println("");
        }
        
        int z = 0;
        for(int i = 0; i < length; i++){
            if(guessed[i] != chosenWord.charAt(i)){
                z++;
            }
        }
        if(z == 0){
            System.out.println("YOU WIN");
            System.out.println("The word was " + chosenWord);
            System.out.println("");
        }
        
        return lives;        
    }
}
