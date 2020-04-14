public class ListClassExample {
    private String[] words;       // actual list of words
    private int nextPosition;     // next available position for a word

    /**
     * Creates a list that is capable of storing 5 words.
     * This is the 'default' size of a list.
     */
    public ListClassExample() {
        words = new String[5];
        nextPosition = 0;
        //this(5); // <--- shortcut. Useful but not necessary/essential.
    }

    /**
     * Creates a list that is capable of storing the number 
     * of words specified by the value of the 'capacity' parameter .
     * 
     * @param      capacity   - the user's preferred list size
     */
    public ListClassExample(int capacity)  {
        words = new String[capacity];
        nextPosition = 0;
    }
    
    /**
     * Inserts a new word into the NEXT AVAILABLE position in the list 
     * if there is space available.
     * Returns true if successful; false otherwise.
     * 
     * @param      word   the word to be added
     * @return            true if the add is successsful; false otherwise 
     */    
    public boolean add(String word) {
        // Check if there is space for an additional word.
        // If nextPosition is less than the size of the list
        // then there must be space for (at least) one
        // more word so we can be sure we add a new word.
        if(nextPosition < words.length) {  
            // Put the word in the next available position
            words[nextPosition] = new String(word);
            nextPosition++;
            return true;
        }                                     
        // If we reach here then the list was full
        // and we were unable to insert a new item.
        return false;
    }
    
    /**
     * Inserts a new word into the FIRST position in the list if there is 
     * space available for it. The word is inserted into position 0 (i.e. 
     * the FIRST position). The existing words in the list are ALL moved 
     * 'up' one position to accommodate the insertion.
     * Returns true if successful; false otherwise.
     * 
     * @param      word   the word to be added
     * @return            true if the add is successsful; false otherwise 
     */
    public boolean addFirst(String word) {
        // Check if there is space for an additional word.
        // If nextPosition is less than the size of the list
        // then there must be space for (at least) one
        // more word so we can be sure we add a new word.
        if(nextPosition < words.length) {  
            // Move the words currently in the list 'up' one position
            // to make space in position 0
            int i;
            for(i = nextPosition; i >= 0 ; i--) {
                words[i+1] = words[i];
            }
            words[0] = new String(word);
            nextPosition++;
            return true;
        } 
        // If we reach here then the list was full
        // and we were unable to insert a new item.
        return false;
    }

    
    /**
     * Display the word list.
     * 
     * @param      none
     * @return     none 
     */
    public void display() {
        int i ;
        for(i = 0; i < nextPosition; i++) {
            System.out.println(words[i]);
        }
    }

    /**
     * Checks the list to see if it contains a word.
     * 
     * @param      word   the word you are searching for
     * @return            ture is the list contains the word; false otherwise 
     */
    public boolean contains(String searchWord) {
        int i ;
        // Check ONLY the items used in the list
        // If the list has capacity for say 256
        // but only 10 have been used then OBVIOUSLY
        // we should only search the (10) used items
        for(i = 0; i < nextPosition; i++) {
            // Using the String class compareToIgnoreCase method
            // makes it easier to compare two Strings
            // So we compare the word in the list at position i
            // with the search word
            if(words[i].compareToIgnoreCase(searchWord) == 0) {
                // if the words are the same then we have found it so return true
                // NOTE: once we reach the return statement the method stops
                return true;
            }
        }
        // If we reach this point then we MUST have gone through all
        // the entries currrently in the list and NOT found the word
        // so we can confidently return false
        return false;
    }
    
    /**
     * Randomly permutes the list using values generated using Math.random.
     * 
     * @param      none
     * @return     none
     */
    public void shuffle() {
        int maxShuffle = words.length * 2;
        int j;
        int k;
        String temp;
        int i;
        for(i=0; i < maxShuffle; i++) {
            // Pick two random positions in the list
            j = (int)(Math.random()*words.length);
            k = (int)(Math.random()*words.length);
            // Swap the values in the chosen positions
            temp = words[j];
            words[j] = words[k];
            words[k] = temp;
        }
    }
}
