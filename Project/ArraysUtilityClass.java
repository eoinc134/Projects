import java.util.*;

public class ArraysUtilityClass {
    public static void main(String[] args) {
        String[] names = { "Aaron", "Adam", "Alan", "Amr", "Andrei", "Andrew", "Andriy", "Annie", "Barry", 
                           "Bartlomiej", "Ben", "Benjamin", "Brian", "Bryan", "Callum", "Calvin", "Chrstian",
                           "Cian", "Clodagh", "Colin", "Colm", "Colum", "Craig", "Daniel", "David", "Dawid",
                           "Dean", "Denis", "Denisio", "Dwain", "Eamonn", "Edward", "Elliot", "Elton", "Enda",
                           "Eoin", "Eryk", "Evan", "Fawad", "Fiston", "Gabriel", "Garreth", "Gerard", 
                           "Griselda", "Harneet", "Ian", "Jack", "Jim", "John", "Jonathan", "Jordan", "Josh",
                           "Joshua", "Kacper", "Kamil", "Keith", "Kevin", "Lakeisha", "Laszlo", "Leon", 
                           "Lorcan", "Luke", "Maeliosa", "Maksymilian", "Mary", "Max", "Micheal", "Michelle", 
                           "Mohamed", "Natalie", "Nathan", "Oliver", "Oran", "Oscar", "Padraig", "Paraic", 
                           "Patrick", "Patrick James", "Paulis", "Piotr", "Quinn", "Rachel", "Richard", "Robert",
                           "Ronan", "Ross", "Ruairi", "Samuel", "Sean", "Seanie", "Sergejs", "Shafiul", "Shane",
                           "Tamara", "Thomas", "Tiernan", "Tito", "Tomas", "Tommie", "Usman", "Wayne", "Wiktoria"
                         };

        String[] apostles = Arrays.copyOf(names,12);

        System.out.println("Original Names: " + Arrays.toString(names));
        
        System.out.println("First 12 names from Original List: " + Arrays.toString(apostles));        

        System.out.println("Original Names Listed Vertically: \n" + Arrays.toString(names).replace(",","\n"));

        Arrays.sort(names,5,14);
        System.out.println("Original Names Partially Sorted (5:14): \n" + Arrays.toString(names).replace(",","\n"));

        Arrays.sort(names);
        System.out.println("Original Names Sorted: \n" + Arrays.toString(names).replace(",","\n"));
        
        System.out.println("Search for Oscar: " + Arrays.binarySearch(names, "Oscar"));
        System.out.println("Search for Rachel: " + Arrays.binarySearch(names, "Rachel"));
        System.out.println("Search for Edsgar: " + Arrays.binarySearch(names, "Edsgar"));
        System.out.println("Search for Clodagh: " + Arrays.binarySearch(names, "Clodagh"));
        
        Arrays.sort(apostles);
        System.out.println("First 12 names Sorted: \n" + Arrays.toString(apostles).replace(",","\n"));
        // Convert "apostles" names in odd numbered positions to upper case
        for(int i = 1; i < apostles.length; i=i+2) {
            apostles[i] = apostles[i].toUpperCase();
        }
        System.out.println("First 12 names AFTER odd elements converted to uppercase: " + 
                                                       Arrays.toString(apostles).replace(",","\n"));        
        Arrays.sort(apostles);
        System.out.println("First 12 names Sorted AFTER odd elements converted to uppercase: " + 
                                                       Arrays.toString(apostles).replace(",","\n"));        

        Arrays.sort(apostles, String.CASE_INSENSITIVE_ORDER);
        System.out.println("First 12 names Sorted AFTER odd elements converted to uppercase using CASE INSENSITIVE ORDER: " +
                                                       Arrays.toString(apostles).replace(",","\n"));        
 
        apostles = Arrays.copyOf(apostles,apostles.length*2);
        System.out.println("Apostles array extended to twice the size " + Arrays.toString(apostles));

        apostles = Arrays.copyOf(apostles,apostles.length/2);
        System.out.println("Apostles array contracted to half the size " + Arrays.toString(apostles));

        apostles = Arrays.copyOf(apostles,apostles.length/2);
        System.out.println("Apostles array contracted to half the size AGAIN " + Arrays.toString(apostles));
    }
}
