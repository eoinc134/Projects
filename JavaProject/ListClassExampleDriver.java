
public class ListClassExampleDriver {
    public static void main(String[] args) {
        // Create an instance of the class using the default constructor
        ListClassExample OED;
        OED = new ListClassExample();
        // Using the OED instance
        OED.display();
        OED.add("Java");
        OED.add("programming");
        OED.display();
        OED.addFirst("Isn't");
        OED.add("great");
        OED.display();
        // Create an instance of the class using the alternative constructor
        ListClassExample emoticons = new ListClassExample(15);       
        // We'll use this instance to store Strings with emoticons in them
        emoticons.display();
        emoticons.add(":)");
        emoticons.add(":]");
        emoticons.display();
        emoticons.add(":(");
        emoticons.add(":D");
        emoticons.display();
        // Searching for something
        System.out.printf("Is the word 'great' is in the OED list? %b.\n",OED.contains("great"));
        System.out.printf("Is the word 'university' is in the OED list? %b.\n",OED.contains("university"));
        OED.add("university");
        System.out.println("Just added the word 'university' to the OED list.");
        if(OED.contains("university")) {
            System.out.println("The word list contains 'university' ");
        }
        // Use the Shuffle operation
        System.out.println("Word list now...");
        OED.display();
        System.out.println("Shuffling word list...");
        OED.shuffle();
        System.out.println("Word list after shuffle...");
        OED.display();
    }
}
