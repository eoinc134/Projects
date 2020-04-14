import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.io.* ;
//David Woods: 19252919
//Eoin Costello: 19255551
//Sean Ryan: 19236697
//Andrew McMahon: 19258054
public class WordSearchPuzzle
{
    private char[][] puzzle ;
    private ArrayList<String> puzzleWords;

    public WordSearchPuzzle(ArrayList<String> userSpecifiedWords){
        int i;
        int longest = 0;
        puzzleWords = new ArrayList<String>();
        for(i = 0; i < userSpecifiedWords.size(); i++){            
            if(userSpecifiedWords.get(i).length() > longest){
                longest = userSpecifiedWords.get(i).length();//finds longest word
            }
        }
        for(int j = 0; j < userSpecifiedWords.size(); j++){
            String word = userSpecifiedWords.get(j);
            word = word.toUpperCase();
            puzzleWords.add(word);
        }
        this.puzzle = new char[(longest + 2)][(longest + 2)];//sets dimensions
        
        Collections.sort(puzzleWords);
    }   

    public WordSearchPuzzle(String wordFile, int wordCount, int shortest, int longest){
        int temp ;
        if(shortest > longest){//swaps in case shortest > longest
            temp = longest ;
            longest = shortest ;           
            shortest = temp ;
        }        
        
        puzzleWords = loadWordsFromFile(wordFile, shortest, longest) ;
        ArrayList<String> chosen = new ArrayList<String>();//Arraylist of strings
        int i, j, largest = 0, sum = 0;        
        for(i = 0; i < wordCount; i++){
            int pos = (int)((Math.random() * puzzleWords.size()));
            chosen.add(puzzleWords.get(pos));        
        }

        for(i = 0 ; i < chosen.size(); i++){//finds the longest word
            if(chosen.get(i).length() > largest){
                largest = chosen.get(i).length() ;
            }
        }       
        
        int count = 0 ;
        for(int x = 0 ; x < chosen.size(); x++){
            count = count + chosen.get(x).length() ;//given characters     
        }
        count = (int)((Math.sqrt(count)) * 1.75) ;//square root * scaling factor = dimension
        this.puzzle = new char[count][count];//sets dimensions        
        puzzleWords = chosen;//adds words to ArrayList
        Collections.sort(puzzleWords);
    }

    private ArrayList<String> loadWordsFromFile(String filename, int shortest, int longest){
        // BasicEnglish.txt or BNCwords.txt
        try {
            FileReader aFileReader = new FileReader(filename);//new file reader
            BufferedReader aBufferReader = new BufferedReader(aFileReader);//new buffered reader
            String lineFromFile;
            int len ;
            ArrayList<String> words = new ArrayList<String>();//new arrayList
            lineFromFile = aBufferReader.readLine() ;
            while (lineFromFile != null) {
                len = lineFromFile.length() ;
                if(len >= shortest && len <= longest) {//if the word suits the specified criteria
                    words.add(lineFromFile.toUpperCase());
                }
                lineFromFile = aBufferReader.readLine() ;
            }
            aBufferReader.close();//close the reader
            aFileReader.close();//close the reader
            return words ;
        }catch(IOException x){
            return null;        
        }   
    } 

    public ArrayList<String> getWordSearchList(){
        return this.puzzleWords;//return words used
    }

    public char[][] getPuzzleAsGrid(){
        return this.puzzle;//Return puzzle as grid
    }

    public String getPuzzleAsString(){
        String a = "" ;
        int r,c = 0 ;
        for(r = 0; r < puzzle.length; r++){               
            for(c = 0; c < puzzle[0].length; c++){
                a = a + (puzzle[r][c])+ " ";//string equal to value at [r][c]
            }
            if(c == puzzle.length){
                a = a + "\n";//new line
                c = 0 ;//reset "c" to 0
            }
        }
        return a ;//Return puzzle as string
    }


    ArrayList<String> wordPosDir = new ArrayList<String>();
    private void generateWordSearchPuzzle(){
        int i = 0, direction, wordUsed = 0, row = 0, col = 0, k, counter = 0;
        puzzle = this.puzzle ;
        
        while(i < puzzleWords.size()){//while i is less than the size of the list of words
            //pick random direction and position
            direction = (int)(Math.random() * 4) ;
            row = (int)(Math.random() * (puzzle[0].length)) ;
            col = (int)(Math.random() * (puzzle.length)) ;
            char charTemp;
            
            //temp values for row and col
            int coltemp = col ;
            int rowtemp = row ;
            
            if(direction == 0){
                charTemp = 'R';//right to left
                //check if there is enough spaces
                if(puzzle.length - col >= puzzleWords.get(i).length()){
                    //check if there is enough EMPTY spaces
                    for(counter = 0; counter < puzzleWords.get(i).length(); counter++){
                        //increment through col
                        if((Character.isLetter(puzzle[row][coltemp])) == false){            
                            coltemp++;            
                        } else {
                            //else statement breaks loop
                            counter = puzzleWords.get(i).length() + 1 ;            
                        }
                    }
                    //check if there were enough empty spaces
                    if(counter == puzzleWords.get(i).length()){            
                        wordPosDir.add(puzzleWords.get(i) + "[" + row + "]" + "[" + col + "]" + charTemp);
                        k = 0 ;                       
                        //put in the characters of the chosen word one by one
                        while(k < puzzleWords.get(i).length()){
                            puzzle[row][col] = puzzleWords.get(i).charAt(k) ;            
                            col++ ;
                            k++ ;
                        }                        
                        i++;
                    }            
                }
            } else if(direction == 1) {
                charTemp = 'L';//left to right
                if(col + 1 >= puzzleWords.get(i).length()){
                    for(counter = 0 ; counter < puzzleWords.get(i).length(); counter++){
                        if((Character.isLetter(puzzle[row][coltemp])) == false){            
                            coltemp-- ;            
                        }else{
                            counter = puzzleWords.get(i).length() + 1 ;            
                        }
                    }
                    if(counter == puzzleWords.get(i).length()){
                        k = 0;
                        wordPosDir.add(puzzleWords.get(i) + "[" + row + "]" + "[" + col + "]" + charTemp);
                        while(k < puzzleWords.get(i).length()){            
                            puzzle[row][col] = puzzleWords.get(i).charAt(k) ;            
                            col--;
                            k++;
                        }
                        i++ ;
                    }            
                }            
            } else if(direction == 2) {     
                charTemp = 'D';//downwards
                if(puzzle[0].length - row >= puzzleWords.get(i).length()){
                    for(counter = 0 ; counter < puzzleWords.get(i).length(); counter++){
                        if((Character.isLetter(puzzle[rowtemp][col])) == false){            
                            rowtemp++;            
                        }else{
                            counter = puzzleWords.get(i).length() + 1;            
                        }
                    }
                    if(counter == puzzleWords.get(i).length()){            
                        k = 0;
                        wordPosDir.add(puzzleWords.get(i) + "[" + row + "]" + "[" + col + "]" + charTemp);
                        while(k < puzzleWords.get(i).length()){            
                            puzzle[row][col] = puzzleWords.get(i).charAt(k);            
                            row++;
                            k++;            
                        }
                        i++;
                    }            
                }
            } else if(direction == 3) {
                charTemp = 'U';//upwards
                if(row + 1 >= puzzleWords.get(i).length()){
                    for(counter = 0; counter < puzzleWords.get(i).length(); counter++){
                        if((Character.isLetter(puzzle[rowtemp][col])) == false){            
                            rowtemp--;            
                        }else{
                            counter = puzzleWords.get(i).length() + 1;            
                        }
                    }
                    if(counter == puzzleWords.get(i).length()){
                        k = 0;
                        wordPosDir.add(puzzleWords.get(i) + "[" + row + "]" + "[" + col + "]" + charTemp);
                        while(k < puzzleWords.get(i).length() ){            
                            puzzle[row][col] = puzzleWords.get(i).charAt(k);           
                            row--;
                            k++;            
                        }
                        i++;
                    }            
                }
            }
        }
        int a,j;

        char[] alphabet = {('A'),('B'),('C'),('D'),('E'),('F'),('G'),('H'),('I'),('J'),('K'),('L'),('M'),
                ('M'),('N'),('O'),('P'),('Q'),('R'),('S'),('T'),('U'),('V'),('W'),('X'),('Y'), ('Z')};

        for(i = 0; i < puzzleWords.size(); i++){
            //goes through the grid and if no character is in place it randomly adds one from the alphabet
            for(a = 0; a < puzzle.length; a++){
                for(j = 0; j < puzzle[0].length; j++){
                    if(Character.isLetter(puzzle[a][j]) == false){
                        int z = (int)((Math.random() * alphabet.length));
                        puzzle[a][j] = alphabet[z] ;            
                    }            
                }
            }        
        }
    }    


    public void showWordSearchPuzzle(boolean hide){
        generateWordSearchPuzzle() ;
        int b, c;
        for(b = 0; b < puzzleWords.size(); b++)//Until i = size of words list
        {
            System.out.println(puzzleWords.get(b));//Print word at this position
        }
        System.out.println(getPuzzleAsString());//Prints the puzzle as string        
        if(hide == true){
            getWordSearchList();   //returns List of Words in Puzzle
        } else {
            System.out.println(wordPosDir);
        }
    } 
}