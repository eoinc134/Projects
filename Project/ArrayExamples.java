public class ArrayExamples {
    
    public String randomNameFromList() {
        // Randomly pick a name from a list of names
        String[] names = {"Padraig", "Fiston", "Kevin", "Bryan", "Wayne", "Mohamed", "Maeliosa", 
                          "Brian", "Andriy", "Kacper", "Paulis", "Eamonn", "Thomas", "Elliot", 
                          "Colm", "Tommie", "Usman", "Kamil", "Rachel", "Jack", "Annie", "Ian", 
                          "Clodagh", "Dawid", "Leon", "Jordan", "Luke", "Andrei", "Richard", 
                          "Harneet", "Ross", "Barry", "Daniel", "John", "Ben", "Sergejs", "Denis",
                          "Oscar", "David", "Josh", "Gabriel", "Tomas", "Griselda", "Michel", 
                          "Bartlomiej", "Colum", "Benjamin", "Piotr", "Sean", "Mark", "Nathan", 
                          "Callum", "Luke", "Tiernan", "Michelle", "Patrick James", "Dean", "Eoin",
                          "Jonathan", "Evan", "Keith", "Shafiul", "Tito", "Ronan", "Craig", "Paraic",
                          "Oliver", "Edward", "Gerard", "Denisio", "Dwain", "Garreth", "Andrew",  
                          "Lakeisha", "Enda", "Amr", "Elton", "Joshua", "Jim", "Eryk", "Max", 
                          "Tamara", "Robert", "Maksymilian", "Alan", "Samuel", "Shane", "Chrstian",
                          "Seanie", "Calvin", "Fawad", "Adam", "Oran", "Cian", "Patrick", "Natalie",
                          "Quinn", "Colin", "Laszlo", "Lorcan", "Wiktoria", "Aaron", "Mary", "Ruairi" } ;
        int r = (int)(Math.random()*names.length);
        return names[r];
        // Alternatively
        // return names[(int)(Math.random()*names.length)];
    }
    
    public String randomWord() {
        // Randomly pick an item from a list.
        String profoundText = 
          /* Billy Joel */
          "so my child and i came to this this place " +
          "to meet him eye to eye and face to face " +
          "he made my daughter laugh then we embraced " +
          "we never knew what friends we had until we came to leningrad " +
          /* The Eagles */
          "now it seems to me some fine things have been laid upon your " +
          "table but you only want the ones that you can't get " +
          /* and The Eagles again */
          "we satisfy our endless needs and justify our bloody deeds " +
          "in the name of destiny and in the name of God " +
          /* Mike and the Mechanics */
          "we all talk a different language talking in defence " +
          "say it loud say it clear you can listen as well as you hear " +
          /* Albert Einstein */
          "Not everything that counts can be counted " +
          "and not everything that can be counted counts " +
          /* Peter Medawar */
          "The human mind treats a new idea the same way the body treats " +
          "a strange protein; it rejects it " ;
          
        // Using the String class "split" operation we can separate the contents
        // of a String on the basis of some characteristic of the text in the string.
        // For example, the following example splits the string "profoundText" into the
        // parts separated by a space and stores each part in a position in the String
        // array called "words" 
        String[] words = profoundText.split(" ");  
        int r = (int)(Math.random()*words.length);
        return words[r];
        // Alternatively
        // return words[(int)(Math.random()*words.length)];
    }
    
    public String jumble(String word) {
        int p, q;
        char ch;
        // Strings are really useful but one problem with them is that
        // you cannot change them (i.e. they are immutable). To change
        // a String Java creates a new String which is a copy of the old
        // String with the modifications applied. Then it throws away the
        // old String. It's like when a credit card gets damaged or worn
        // the bank issues a new card instead of trying to fix the old one.
        // So to jumble the letters in a word (i.e. String) we need to create
        // a new String AFTER we have shuffled the characters in the string.
        // To shuffle the characters easily we transfer them to an array,
        // shuffle them in the array, and then put them into a new String.
        // Conveniently, the String class has a toCharArray operation which
        // creates an array of characters and loads it with the characters
        // from the String.
        char[] wordChars = word.toCharArray();
        // Now we can shuffle them around by randomly picking two positions
        // and swapping the characters in the positions. If we do that enough
        // times we should get the characters in the string jumbled up reasonably
        // well.
        for(int i = 0; i  < word.length(); i++) {
            // pick two random positions
            p = (int)(Math.random()*word.length());
            q = (int)(Math.random()*word.length());
            // swap the two values
            ch = wordChars[p];
            wordChars[p] = wordChars[q];
            wordChars[q] = ch;
        }
        // Now create a new string using the shuffled array
        return new String(wordChars);
    }
    
    public int scrabbleWordScore(String word) {
        int[] scrabblePoints = {1,3,3,2,1,4,2,4,1,8,5,1,3,1,1,3,10,1,1,1,1,4,4,8,4,10};
        //                      A B C D E F G H I J K L M N O P Q  R S T U V W X Y Z
        char ch;
        int alphabetIndex;
        int wordValue = 0;
        // Convert to uppercase for convenience
        word = word.toUpperCase();
        // Traverse the string from beginning to end and score each letter.
        // Q. Could we traverse the string from end to beginning?
        // Q. Would it make any difference?
        for (int i = 0; i < word.length(); i++) {
            // identify one character
            ch = word.charAt(i);
            if(Character.isLetter(ch)) {
                // compute the letter's position in the alphabet 
                alphabetIndex = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".indexOf(ch);
                // Alternatively
                // alphabetIndex = ch-'A'
                wordValue = wordValue + scrabblePoints[alphabetIndex];
            }
        }
        return wordValue;
    }
}
