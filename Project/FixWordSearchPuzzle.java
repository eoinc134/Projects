import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.io.* ;
public class FixWordSearchPuzzle
{
    private char[][] puzzle ;
    private ArrayList<String> puzzleWords;

    public FixWordSearchPuzzle(ArrayList<String> userSpecifiedWords){
        int i;
        int longest = 0;
        for(i = 0; i < userSpecifiedWords.size(); i++){
            if(userSpecifiedWords.get(i).length() > longest){
                longest = userSpecifiedWords.get(i).length();//finds longest word
            }
        }
        this.puzzle = new char[(longest + 2)][(longest + 2)];//sets dimensions
        puzzleWords = userSpecifiedWords ; //adds words to ArrayList      
    }   

    public FixWordSearchPuzzle(String wordFile, int wordCount, int shortest, int longest){
        int temp ;
        if(shortest > longest){//swap values in case shortest > longest
            temp = longest ;
            longest = shortest ;
            shortest = temp ;
        }        
        
        puzzleWords = loadWordsFromFile(wordFile, shortest, longest) ;
        ArrayList<String> chosen = new ArrayList<String>();//Arraylist of strings
        int i,j,largest = 0, sum = 0;        
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
            count = count + chosen.get(x).length();//number of characters        
        }
        count = (int)((Math.sqrt(count * 1.75)));//get dimensions
        this.puzzle = new char[count][count];        
        puzzleWords = chosen;//adds words to ArrayList
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
        return this.puzzle;//returns 2D array
    }

    public ArrayList<String> getWordSearchList(){
        return this.puzzleWords;//returns list of chosen words
    }

    public char[][] getPuzzleAsGrid(){    
        return puzzle;//Return puzzle as grid
    }

    public String getPuzzleAsString(){
        String a = "" ;
        int r, c;
        for(r = 0; r < puzzle.length; r++){               
            for(c = 0; c < puzzle[0].length; c++){
                a = a + (puzzle[r][c])+ " ";//string is equal to the values at [r][c]
            }
            if(c == puzzle.length){//if "c" = puzzle length
                a = a + " \n " ;//new line
                c = 0 ;
            }
        }
        return a ;//Return the puzzle as string
    }

    /*public void showWordSearchPuzzle(){
        generateWordsearchpuzzle() ;
        int i,j;

        for(i=0; i<puzzleWords.size(); i++)//Until i = size of words list
        {
            System.out.println(puzzleWords.get(i));//Print word at this position
        }
        System.out.println(getPuzzleAsString());//Prints the puzzle as string
    }*/

    public void showWordSearchPuzzle(boolean hide){
        generateWordsearchpuzzle() ;
        int b,c;

        for(b=0; b<puzzleWords.size(); b++)//Until i = size of words list
        {
            System.out.println(puzzleWords.get(b));//Print word at this position
        }
        System.out.println(getPuzzleAsString());//Prints the puzzle as string
        
        
        int col,row;
        int wordLetters = 0;
        int wordNum = 0;
        String check = "";
        String word;
        ArrayList<String> wordPos = new ArrayList<String>();
        if(hide == true){
            getWordSearchList();   //returns List of Words in Puzzle
        } else {
           
           /* while(wordNum < puzzleWords.size()){       //used to check eachword in list
                word = puzzleWords.get(wordNum);
                for(row=0; row<puzzle.length; row++){
                    for(col=0; col<puzzle[0].length; col++){
                        int i, j;
                        i = row;
                        j = col;
                        int cap = 0;             //used to move to next direction
                        wordLetters = 0;         //used for each character of word
                        if(puzzle[row][col] == word.charAt(wordLetters)){
                            check = "";
                            while(wordLetters<word.length()-1 && cap == 0){
                                if(j<puzzle[row].length){         //if it hits array edge itll move to next direction
                                    check = check + puzzle[row][j];
                                    wordLetters++;
                                    j++;
                                } else{
                                    cap = 1;
                                    check = "";
                                    j = col;
                                    wordLetters = 0;
                                }
                            }
                            if(check == word){
                                wordPos.add(word+"["+row+"]"+"["+col+"]"+"R");
                                wordNum++;
                            } else if(check != word){
                                while(wordLetters<word.length()-1 && cap == 1){
                                    if(j >= puzzle[row][0]){
                                        check = check + puzzle[row][j];
                                        wordLetters++;
                                        j--;
                                    } else{
                                        cap = 2;
                                        check = "";
                                        j = col;
                                        wordLetters = 0;
                                    }
                                }
                                if(check == word){
                                    wordPos.add(word+"["+row+"]"+"["+col+"]"+"L");
                                    wordNum++;
                                }    else if(check != word){
                                    while(wordLetters<word.length()-1 && cap == 2){
                                        if(i < puzzle.length){
                                            check = check + puzzle[i][col];
                                            wordLetters++;
                                            i++;
                                        } else{
                                            cap = 3;
                                            check = "";                         
                                            i = row;
                                            wordLetters = 0;
                                        }
                                    }
                                    if(check == word){
                                        wordPos.add(word+"["+row+"]"+"["+col+"]"+"D");
                                        wordNum++;
                                    }
                                    else if(check != word){
                                        while(wordLetters<word.length()-1 && cap == 3){
                                            if(i >= puzzle[0][col]){
                                                check = check + puzzle[i][col];
                                                wordLetters++;
                                                i--;
                                            } else{
                                                cap = 0;
                                            }
                                        }  
                                        if(check == word){
                                            wordPos.add(word+"["+row+"]"+"["+col+"]"+"U");
                                            wordNum++;
                                        }
                                    }
                                }
                            }
                        }
                    }
                } 
            }*/

        }
    } 


    private void generateWordsearchpuzzle(){
        int i = 0, direction, row = 0, col = 0, k, counter = 0;
        puzzle = this.puzzle ;
        while(i < puzzleWords.size()){//while i is less than the size of the list of words
            //pick random direction and position 
            direction = (int)(Math.random() * 4) ;
            row = (int)(Math.random() * (puzzle[0].length)) ;
            col = (int)(Math.random() * (puzzle.length)) ;
            
            //temporary row and col values
            int coltemp = col ;
            int rowtemp = row ;
            
            if(direction == 0){
                //left to right
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
            } else if(direction == 1){
                //right to left
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
                        while(k < puzzleWords.get(i).length()){            
                            puzzle[row][col] = puzzleWords.get(i).charAt(k) ;            
                            col--;
                            k++;
                        }
                        i++ ;
                    }            
                }            
            }else if(direction == 2){        
                //downwards
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
                        while(k < puzzleWords.get(i).length()){            
                            puzzle[row][col] = puzzleWords.get(i).charAt(k);            
                            row++;
                            k++;            
                        }
                        i++;
                    }            
                }
            }else if(direction == 3){
                //upwards
                if(row + 1 >= puzzleWords.get(i).length()){
                    for(counter = 0; counter < puzzleWords.get(i).length(); counter++){
                        if((Character.isLetter(puzzle[rowtemp][col])) == false){            
                            rowtemp--;            
                        }else{
                            counter = puzzleWords.get(i).length() + 1 ;            
                        }
                    }
                    if(counter == puzzleWords.get(i).length()){
                        k = 0;
                        while(k < puzzleWords.get(i).length() ){            
                            puzzle[row][col] = puzzleWords.get(i).charAt(k) ;           
                            row--;
                            k++;            
                        }
                        i++ ;
                    }            
                }
            }
        }
        
        int a,j;
        char[] alphabet = {('A'),('B'),('C'),('D'),('E'),('F'),('G'),('H'),('I'),('J'),('K'),('L'),('M'),
                ('N'),('O'),('P'),('Q'),('R'),('S'),('T'),('U'),('V'),('W'),('X'),('Y'), ('Z')};

        for(i = 0; i < puzzleWords.size(); i++){
            //populate empty spaces with random letter
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
}