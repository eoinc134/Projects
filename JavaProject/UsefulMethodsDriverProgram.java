public class UsefulMethodsDriverProgram {
    public static void main(String[] args) {
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
        String aName;
        String aPassword;
        int randomPosition;
        int i;
        
        aPassword = UsefulMethods.generatePassword();
        System.out.printf("'%s' is a password generated with UsefulMethods.generatePassword()\n",aPassword);
        
        aPassword = UsefulMethods.generatePassword(9);
        System.out.printf("'%s' is a password generated with UsefulMethods.generatePassword(9)\n",aPassword);

        aPassword = UsefulMethods.generatePassword(7,"yourpreferredalphabet");
        System.out.printf("'%s' is a password generated with UsefulMethods.generatePassword(7,\"yourpreferredalphabet\")\n",aPassword);
        
        System.out.printf("\n\n");
        for(i=0; i < 10; i++) {
            randomPosition = (int)(Math.random()*names.length);
            aName = names[randomPosition];
            System.out.printf("'%s' jumbled as '%s' using UsefulMethods.jumble(aName)\n",
                              aName, UsefulMethods.jumble(aName));
        }

        System.out.printf("\n\n");
        for(i=0; i < 10; i++) {
            randomPosition = (int)(Math.random()*names.length);
            aName = names[randomPosition];
            System.out.printf("'%s' scrabble score is %d using UsefulMethods.scrabbleWordScore(aName)\n",
                              aName, UsefulMethods.scrabbleWordScore(aName));
        }

        System.out.printf("\n\n");
        for(i=0; i < 10; i++) {
            System.out.printf("Password %d is '%s'\n",i,UsefulMethods.generatePassword());
        }
       
        System.out.printf("\n\n");
        for( i=0; i < 10; i++) {
            // Randomly pick a name
            aName = "";
            // Keep picking names until you pick one that is between 5 and 7 characters long
            while(aName.length() < 5 || aName.length() > 7) {
                aName = names[(int)(Math.random()*names.length)];
            }
            System.out.printf("'%s' is a random name between 5 and 7 characters long\n",aName);
        }
    }
}
