import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.io.* ;
public class CopyWordSearchPuzzle
{
    private char[][] puzzle ;
    private ArrayList<String> puzzleWords;
    public CopyWordSearchPuzzle(ArrayList<String> userSpecifiedWords){
        int i;
        int longest = 0;
        for(i = 0 ; i < userSpecifiedWords.size(); i++){        
            if(userSpecifiedWords.get(i).length() > longest){
                longest = userSpecifiedWords.get(i).length() ;//sets “longest” as the length of the longest word
            }
        }        
        this.puzzle = new char[longest + 2][longest + 2];//gives the 2d array the dimensions needed to make words ambiguous
        puzzleWords = userSpecifiedWords ; //adds the words to the list “puzzleWords” for use below        
    }   
    
    public CopyWordSearchPuzzle(String wordFile, int wordCount, int shortest, int longest){
        int temp ;
        if(shortest > longest){// if length of shortest word is longer than the longest word, swap the values so selection will be possible
            temp = longest ;//longest is moved to temporary variable
            longest = shortest ;//longest is now = to what shortest was
            shortest = temp ;//shortest is now = to what largest was
        }        
        puzzleWords = loadWordsFromFile(wordFile, shortest, longest) ;
        ArrayList<String> chosen = new ArrayList<String>();//Arraylist of strings
        int i,j,largest = 0, sum = 0;        
        for(i = 0; i < wordCount; i++){
            int pos = (int)((Math.random() * puzzleWords.size()));
            chosen.add(puzzleWords.get(pos));        
        }
        
        for(i = 0 ; i < chosen.size(); i++){//finds the longest word by going through the array
            if(chosen.get(i).length() > largest){
                largest = chosen.get(i).length() ;
            }
        }       
        int count = 0 ;
        for(int x = 0 ; x < chosen.size();x++){
            count = count + chosen.get(x).length() ;//calculates the amount of characters there are in the array        
        }
        count = (int)((Math.sqrt(count)) * 1.75) ;//gets the squareroot of characters and multiplies by 1.75
        this.puzzle = new char[count][count];//sets the dimensions of the puzzle to this size.        
        puzzleWords = chosen;//gives “puzzleWords” the value of the arraylist “chosen”
    }
    
    private ArrayList<String> loadWordsFromFile(String filename, int shortest, int longest){
        // BasicEnglish.txt – the 850 words of Basic English
        // BNCwords.txt – “the 6,318 words with more than 800 occurrences in the whole 100M-word BNC”
        try {
            FileReader aFileReader = new FileReader(filename);//new file reader
            BufferedReader aBufferReader = new BufferedReader(aFileReader);//new buffered reader
            String lineFromFile;
            int len ;
            ArrayList<String> words = new ArrayList<String>();//new arrayList
            lineFromFile = aBufferReader.readLine() ;//reads the line in the file to the string
            while (lineFromFile != null) {//while the string is not empty
                len = lineFromFile.length() ;//len = length of word in string
                if(len >= shortest && len <= longest) {//if the word suits the specified criteria
                    words.add(lineFromFile.toUpperCase());//add it to the arraylist
                }
                lineFromFile = aBufferReader.readLine() ;//reads a line from the file
            }
            aBufferReader.close();//close the reader
            aFileReader.close();//close the reader
            return words ;
        }catch(IOException x){
            return null;        
        }   
    }
    
    public char[][] getpuzzle(){
        return this.puzzle ;
    }
    
    public ArrayList<String> getWordSearchList(){
        return this.puzzleWords;
    }
    
    public char[][] getPuzzleAsGrid(){
        int i,j;        
        char[] a = {('q'),('w'),('e'),('r'),('t'),('y'),('u'),('i'),('o'),('p'),('a'),('s'),('d'),('f'),('g'),('h'),('j'),('k'),('l'),('z'),('x'),('c'),('v'),('b'),('n'),('m')} ;            
        //what the above line  is, is a list of characters that can be used in the puzzle to make the words in there hidden.
        for(i = 0; i < puzzle.length; i++){//goes through the puzzle until variable “i” = the length of the puzzle            
            for(j = 0; j < puzzle[0].length; j++){//goes through the puzzle until variable “j” = the length of the puzzle            
                int z = (int)((Math.random() * a.length));//creates a random number between 0 and the length of the list “a” – 1
                puzzle[i][j] = a[z] ;//Inserts the character at position z in the list a into the puzzle at coordinates [i][j]
                System.out.print(puzzle[i][j] + " ");//prints the action
            }
            System.out.println();
            }
        return puzzle;//Return puzzle as grid
    }
    
    public String getPuzzleAsString(){
        String a = "" ;
        int c,r = 0 ;
        for( c = 0; c < puzzle[0].length; c++){//while “c” is less that the column length                
            for( r = 0; r < puzzle.length; r++){//while “c” is less that the row length
                a = a + (puzzle[r][c])+ " ";//string is equal to the values at coordinates [r][c]
            }
            if( r == puzzle.length){//if “r” = puzzle length
                a = a + " \n " ;//new line
                r = 0 ;//reset “r” to 0
            }
        }
        return a ;//Return the puzzle as string
    }
    
    public void showWordSearchPuzzle(){
        generateWordsearchpuzzle() ;
        int i,j;        
        for(i = 0; i < puzzleWords.size(); i++){//Until i = size of words list        
            System.out.println(puzzleWords.get(i));//Print word at this position
        }
        System.out.println(getPuzzleAsString());//Prints the puzzle as string
    }
    
    private void generateWordsearchpuzzle(){
        int i = 0, rand, wordUsed = 0, row = 0, col = 0, k, empty = 0;
        puzzle = this.puzzle ;
        while(i < puzzleWords.size()){//while “i” is less than the size of the list of words
            //pick random number for direction
            //and random coordinate with row and col
            rand = (int)(Math.random() * 4) ;
            row = (int)(Math.random() * (puzzle[0].length)) ;
            col = (int)(Math.random() * (puzzle.length)) ;
            //stores temp value of col/row so that it can be used to check for empty spaces in loop
            int coltemp = col ;
            int rowtemp = row ;
            //direction of word in puzzle is chosen according to value of random
            if(rand == 0){
                // col/row+1 is done to take into count the actually pos of col/row in the grid
                //if length of puzzle – col/row+1 is greater or equal to length of chosen word then
                //there must be enough spaces for the word to fit
                if(puzzle[0].length - (col + 1) >=puzzleWords.get(i).length()){
                    //next we check to see if there is enough EMPTY spaces to fit the word in
                    for(empty = 0 ; empty <puzzleWords.get(i).length(); empty++){
                        //if no letter is found we move on to check the next col
                        if((Character.isLetter(puzzle[row][coltemp]))==false){            
                            coltemp++ ;            
                        }else{
                            //if not we set empty to a value that will break the loop
                            //and that will not satisfy the next if statement
                            empty = puzzleWords.get(i).length()+1 ;            
                        }
                    }
                    //here we check to see if there was indeed enough empty spaces
                    if(empty == puzzleWords.get(i).length()){            
                        k = 0 ;
                        //put in the characters of the chosen word one by one
                        while(k < puzzleWords.get(i).length()){
                            puzzle[row][col] = puzzleWords.get(i).charAt(k) ;            
                            col++ ;
                            k++ ;
                        }
                        //increment i to move onto the next chosen word
                        i++;
                    }            
                }
            } else if(rand == 1){
                if(puzzle.length - (col + 1) >= puzzleWords.get(i).length() ){
                    for(empty = 0 ; empty <puzzleWords.get(i).length(); empty++){
                        if((Character.isLetter(puzzle[row][coltemp]))==false){            
                            coltemp++ ;            
                        }else{
                            empty = puzzleWords.get(i).length()+1 ;            
                        }
                    }
                    if(empty == puzzleWords.get(i).length()){
                        //same as above except we are putting characters in the word from last till first
                        k = puzzleWords.get(i).length()-1 ;
                        while( k >= 0 ){            
                            puzzle[row][col] = puzzleWords.get(i).charAt(k) ;            
                            col++;
                            k-- ;
                        }
                        // move onto next word
                        i++ ;
                    }            
                }            
            }else if(rand == 2){
                //so the chosen words will be put in in a north or south direction            
                if(puzzle[0].length - (row + 1) >=puzzleWords.get(i).length() && (Character.isLetter(puzzle[row][col]) == false)){
                    for(empty = 0 ; empty <puzzleWords.get(i).length(); empty++){
                        if((Character.isLetter(puzzle[rowtemp][col])) == false){            
                            rowtemp++ ;            
                        }else{
                            empty = puzzleWords.get(i).length() + 1 ;            
                        }
                    }
                    if(empty == puzzleWords.get(i).length()){            
                        k = puzzleWords.get(i).length() - 1 ;
                        while( k >= 0 ){            
                            puzzle[row][col] = puzzleWords.get(i).charAt(k) ;            
                            row++;
                            k-- ;            
                        }
                        i++;
                    }            
                }
            }else if(rand == 3){//same as above
                if(puzzle[0].length - (row + 1) >=puzzleWords.get(i).length() ){
                    for(empty = 0 ; empty <puzzleWords.get(i).length(); empty++){
                        if((Character.isLetter(puzzle[rowtemp][col])) == false){            
                            rowtemp++ ;            
                        }else{
                            empty = puzzleWords.get(i).length() + 1 ;            
                        }
                    }
                    if(empty == puzzleWords.get(i).length()){
                        k = 0 ;
                        while(k < puzzleWords.get(i).length() ){            
                            puzzle[row][col] = puzzleWords.get(i).charAt(k) ;           
                            row++;
                            k++ ;            
                        }
                        i++ ;
                    }            
                }
            }
        }
        int a,j;
        //characters of alphabet in order of how they appear on the keyboard
        char[] alphabet = {('Q'),('W'),('E'),('R'),('T'),('Y'),('U'),('I'),('O'),('P'),('A'),('S'),('D'),('F'),('G'),('H'),('J'),('K'),('L'),('Z'),('X'),('C'),('V'),('B'),('N'),('M')} ;
        for(i = 0;i < puzzleWords.size(); i++){
            //goes through the grid and if no character is in place it randomly adds one from the alphabet
            for(a = 0; a < puzzle.length; a++){
                for(j=0; j < puzzle[0].length; j++){
                    if(Character.isLetter(puzzle[a][j]) == false){
                        int z = (int)((Math.random() * alphabet.length));
                        puzzle[a][j] = alphabet[z] ;            
                    }            
                }
            }        
        }
    }    
}
