import java.util.*;
import java.io.*;
//David Woods: 19252919
//Eoin Costello: 19255551
//Sean Ryan: 19236697
//Andrew McMahon: 19258054
public class DriverForWordSearchPuzzle
{
    private static void test1(){//bncwords.txt, 10 words, shortest = 4, longest = 5
        WordSearchPuzzle wordSearch = new WordSearchPuzzle("bncwords.txt", 10, 4, 5);
        wordSearch.getWordSearchList() ;//gets the list of chose words
        wordSearch.showWordSearchPuzzle(false) ;        
       
        System.out.println();//prints the puzzle
    }
    private static void test2(){//basicenglish.txt, 5 words, shortest = 8, longest = 2 (this test if our statement in second block of code works)
        WordSearchPuzzle wordSearch = new WordSearchPuzzle("basicenglish.txt", 5, 8, 2);
        wordSearch.getWordSearchList() ;
        wordSearch.showWordSearchPuzzle(false) ;
        wordSearch.getPuzzleAsGrid();
        wordSearch.getPuzzleAsString();
        
        System.out.println();
    }
    private static void test3(){        
        ArrayList<String> words = new ArrayList<String>();
        words.add("SEAN");
        words.add("EOIN");
        words.add("ANDREW");
        words.add("DAVID");
        
        WordSearchPuzzle wordSearch = new WordSearchPuzzle(words);
        wordSearch.getWordSearchList() ;
        wordSearch.showWordSearchPuzzle(true) ;
        
        System.out.println();    
    }
    private static void test4(){
        ArrayList<String> words = new ArrayList<String>();
        words.add("SEAN");
        words.add("EOIN");
        words.add("ANDREW");
        words.add("DAVID");
        
        WordSearchPuzzle wordSearch = new WordSearchPuzzle(words);
        wordSearch.getWordSearchList() ;
        wordSearch.showWordSearchPuzzle(false) ;
        
        System.out.println();    
    }
    private static void test5(){ // convert all chars to uppercase
        ArrayList<String> words = new ArrayList<String>();
        words.add("Software");
        words.add("Devolpment");
        words.add("is");
        words.add("ThE");
        words.add("bESt");
        words.add("ModUle");
        
        WordSearchPuzzle wordSearch = new WordSearchPuzzle(words);
        wordSearch.getWordSearchList() ;
        wordSearch.showWordSearchPuzzle(false) ;
        
        System.out.println();    
    }
    public static void main(String[] args){
        System.out.println();
        DriverForWordSearchPuzzle.test1();
        DriverForWordSearchPuzzle.test2();
        DriverForWordSearchPuzzle.test3();
        DriverForWordSearchPuzzle.test4();
        DriverForWordSearchPuzzle.test5();
    }
}
