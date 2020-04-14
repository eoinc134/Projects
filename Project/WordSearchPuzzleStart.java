import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.io.* ;
public class WordSearchPuzzleStart
{
        private char[][] puzzle ;
        private ArrayList<String> puzzleWords;        
        
        public WordSearchPuzzleStart(ArrayList<String> userSpecifiedWords) {
            puzzleWords = userSpecifiedWords;
        }
        
        private static ArrayList<String> loadWordsFromFile(String filename) {
            try {            
                FileReader aFileReader = new FileReader(filename);
                BufferedReader aBufferReader = new BufferedReader(aFileReader);
                ArrayList<String> words = new ArrayList<String>();
                String aWord;
                aWord = aBufferReader.readLine() ;
                while (aWord != null) { 
                    words.add(aWord.toUpperCase());
                    aWord = aBufferReader.readLine() ;
                }
                aBufferReader.close();
                aFileReader.close();
                return words ;
            }
            catch(IOException x) {
                    return null ;
            }
        }
         
        public WordSearchPuzzleStart(String wordFile, int wordCount,
                              int shortest, int longest){
             int i = 0;
             ArrayList<String> fileWords = loadWordsFromFile(wordFile);
             int randNum = (int)(Math.random() * fileWords.size());
             String fileWord = "";
             while(i < wordCount){
                 fileWord = fileWords.get(randNum);
                 if(fileWord.length() >= shortest && fileWord.length() <= longest){
                    puzzleWords.add(fileWord);
                    i++;
                 }
             }
        }
        
        private int dimensions(){
            String wordTemp;
            double givenCharacters = 0;
            for(int i = 0; i < puzzleWords.size(); i++){
                wordTemp = puzzleWords.get(i);
                givenCharacters = givenCharacters + wordTemp.length();                
            }
            double totalCharacters = (givenCharacters * 1.75);
            int dimensions = (int)(Math.sqrt(totalCharacters));
            return dimensions;
        }
        
        public ArrayList<String> getWordSearchList(){
            return puzzleWords;
        }
     
        public char[][] getPuzzleAsGrid(){                      
            puzzle = new char[dimensions()][dimensions()];
            return puzzle;
        }
     
        public String getPuzzleAsString(){
            puzzle = new char[dimensions()][dimensions()];
            String wordSearchString = "";
            for(int i = 0; i < puzzle.length; i++){
                for(int j = 0; j < puzzle[0].length; j++){
                    wordSearchString = wordSearchString + puzzle[i][j];
                }
            }            
            return wordSearchString;
        }
     
        public void showWordSearchPuzzle(boolean hide){
            int col,row;
            int wordLetters = 0;
            int wordNum = 0;
            String check = "";
            String word;
            ArrayList<String> wordPos = new ArrayList<String>();
            if(hide == true){
                //getWordSearchList();
            } else {
                while(wordNum < puzzleWords.size()){
                    word = puzzleWords.get(wordNum);
                    for(row = 0; row < puzzle.length; row++){
                        for(col = 0; col < puzzle[0].length; col++){
                            int i, j;
                            i = row;
                            j = col;
                            if(puzzle[row][col] == word.charAt(wordLetters)){
                                while(wordLetters < word.length()){
                                    check = check + puzzle[row][j];
                                    wordLetters++;
                                    j++;
                                }
                                if(check == word){
                                    wordPos.add(word + "[" + row + "]" + "[" + col + "]" + "R");
                                } else if(check != word) {
                                    check = "";
                                    j = col;
                                    while(wordLetters < word.length()){
                                        check = check + puzzle[row][j];
                                        wordLetters++;
                                        j--;
                                    }
                                    if(check == word){
                                        wordPos.add(word + "[" + row + "]" + "[" + col + "]" + "L");
                                    } else if(check != word) {
                                        check = "";
                                        while(wordLetters < word.length()){
                                            check = check + puzzle[i][col];
                                            wordLetters++;
                                            i++;
                                        }
                                        if(check == word){
                                            wordPos.add(word + "[" + row + "]" + "[" + col + "]" + "D");
                                        } else {
                                            wordPos.add(word + "[" + row + "]" + "[" + col + "]"  +"U");  
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                System.out.print(wordPos);
            }
        }         
        
        private void generateWordSearchPuzzle(){
            int count = puzzleWords.size();             
            String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
            while(count > 0){
                int direction = (int)(Math.random() * 4);
                int row = (int)(Math.random() * dimensions());
                int col = (int)(Math.random() * dimensions());
                String word = puzzleWords.get(count);               
                if(direction == 0){
                    if(row >= word.length()){                                                                
                        int counter = 0 ;                            
                        for(int k = 0; k > alphabet.length(); k++){                                                               
                                for(int r = row; r > word.length(); r--){
                                    if(puzzle[r][col] == alphabet.charAt(k)){
                                        counter++;
                                    }
                                }
                            }
                        if(counter == 0){
                            for(int i = 0; i < word.length(); i++){                                                        
                                puzzle[row - i][col] = word.charAt(i);
                            }
                        } else {
                            count++;
                        }
                    } else {
                        count++; 
                    }
                } else if(direction == 1){
                    if(dimensions() - row >= word.length() - 1){                        
                        int counter = 0 ;                            
                        for(int k = 0; k > alphabet.length(); k++){                                                               
                                for(int r = row; r < word.length(); r++){
                                    if(puzzle[r][col] == alphabet.charAt(k)){
                                        counter++;
                                    }
                                }
                        }
                        if(counter == 0){
                            for(int i = 0; i < word.length(); i++){
                                puzzle[row + i][col] = word.charAt(i);
                            }
                        } else {
                            count++;
                        }
                    } else{
                        count++;
                    }
                } else if(direction == 2){
                    if(col >= word.length()){
                        int counter = 0 ;                            
                        for(int k = 0; k > alphabet.length(); k++){                                                               
                                for(int c = col; c > word.length(); c--){
                                    if(puzzle[row][c] == alphabet.charAt(k)){
                                        counter++;
                                    }
                                }
                            }
                        if(counter == 0){
                            for(int i = 0; i < word.length(); i++){
                                puzzle[row][col - i] = word.charAt(i);
                            }
                        } else {
                            count++;
                        }
                    } else {
                        count++;
                    }
                } else if(direction == 3){
                    if(dimensions() - col >= word.length() - 1){
                        int counter = 0 ;                            
                        for(int k = 0; k > alphabet.length(); k++){                                                               
                                for(int c = col; c < word.length(); c++){
                                    if(puzzle[row][c] == alphabet.charAt(k)){
                                        counter++;
                                    }
                                }
                            }
                        if(counter == 0){
                            for(int i = 0; i < word.length(); i++){
                                puzzle[row][col + i] = word.charAt(i);
                            }
                        } else {
                            count++;
                        }
                    } else {
                        count++;
                    }
                }
                count--;
            }
            //fill empty gaps            
            for(int r = 0; r < dimensions(); r++){                
                for(int c = 0; c < dimensions(); c++){
                    int counter = 0;
                    for(int k = 0; k > alphabet.length(); k++){
                        if(puzzle[r][c] == alphabet.charAt(k)){
                            counter++;
                        }
                    }
                    if(counter == 0){
                        puzzle[r][c] = alphabet.charAt((int)(Math.random() * 26));
                    }
                }
            }
        }
}
