import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ArrayListExercise2
{
    private ArrayList<String> names ;

    public ArrayListExercise2() {
      names = new ArrayList<String>(Arrays.asList(
                "Cyiaph", "Bartlomiej", "Wasim", "Kitara", "Nadine", 
                "Eoin", "Ayoub", "Jessica", "Creed", "Elizabeth", 
                "Ethan", "Lucy", "Jordan", "Robin", "Kieran", "James",
                "Padraig", "Sai_Swaroop", "Steven", "Bandile", "Shane",
                "Oleg", "Emmett", "Sean", "Luke", "Arnas", "Kamil",
                "Chris", "Mary", "Marcin", "Dylan", "Nikita", "Cian",
                "Lydia", "Stephen", "Michele", "Oran", "Amr", 
                "Ashutosh", "Damian", "John", "Daniel", "Aidan", "Jalaj",
                "Daragh", "Paul", "Jamie", "Jelizaveta", "Mackevic",
                "Oisin", "Emily", "Diarmuid", "Pearl", "Desmond", 
                "Ruixue", "Nicole", "Craig", "Edward", "Padraig", "Darragh",
                "Aleksandr", "Michael", "Miracle", "Zhen", "Fionn", "Philip",
                "Graham", "Ademide", "Terence", "Ronan", "George", "Cathal",
                "Jamie", "Matt", "Thomas", "Colm", "Aaron", "Ranya", 
                "Nathan", "Rioghan", "Michael", "Alannah", "Liam", "Shaun",
                "Emmet", "Ruairi", "Ronan", "Conor", 
                "Surya", "Stuart", "Jakub", "Keith", "Rhys", "Maciej", 
                "Caoin", "Scott", "Erona", "Sorcha", "Federico", "Athul",
                "Dermot", "Edsgar", "Donald", "Niklaus"));
    }
    
    public void capitalise(){
        String capatalisedName;
        for(int i = 0; i < names.size(); i++){
            capatalisedName = names.get(i);
            capatalisedName = Character.toUpperCase(capatalisedName.charAt(0))
            + capatalisedName.substring(1).toLowerCase();
            names.set(i, capatalisedName);
        }
    }
    
    public ArrayList<String> removeWordsStartingWith(String portion){
        System.out.println(names.toString());
        ArrayList<String> namesRemoved = new ArrayList<String>();
        for(int i = names.size()-1; i >= 0; i--){
            if(names.get(i).startsWith(portion)){
                namesRemoved.add(names.get(i));
                names.remove(i);
            }
        }
        System.out.println(names.toString());
        return namesRemoved;
    }
   
    private int vowelCount(String s){
        int count = 0;
        for(char ch : s.toCharArray()){
            if("aeiouAEIOU".indexOf(ch) != -1){
                count++;
            }
        }
        return count;
    }
    
    public int vowelCount(){
        int vowelTotal = 0;
        for(String s : names){
            vowelTotal += vowelCount(s);
        }
        return vowelTotal;
    }
    
    public String firstNameAlphabetically(){
        return Collections.min(names);
    }
    
    public String lastNameAlphabetically(){
        return Collections.max(names);
    }
}
