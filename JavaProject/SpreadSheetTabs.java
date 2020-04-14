public class SpreadSheetTabs{
    private String[] sheets;
    private int nextPosition;
    private int nextSheetNumber;
    private int i, j, k;
    private String temp;
    public SpreadSheetTabs(){
       sheets = new String [256];//set capacity of array
       sheets[0] = "Sheet1";
       sheets[1] = "Sheet2";
       sheets[2] = "Sheet3";
       nextPosition = 3;//next index position
       nextSheetNumber = 4;//next sheet number (user-side index)
    } 
        
    public boolean add(String sheetN){
       if (nextPosition < sheets.length){//ensures there are less than 256 sheets
             sheetN = "Sheet" + nextSheetNumber;//sets default name for sheet
             sheets[nextPosition] = new String(sheetN);//adds new sheet
             nextPosition++;//moves index position up one
             nextSheetNumber++;//next default for sheetN
             return true;
       }
       return false;
    }
    
    public int remove(String sheetName){
       for(i = 0; i < nextPosition; i++){//for loop looks for sheet name and if statement checks if it is there
             if(sheets[i].compareToIgnoreCase(sheetName) == 0 && nextPosition > 1){
                  for(j = nextPosition - 1; j > i; j--){
                        sheets[j-1] = sheets[j];
                  }
                  nextPosition--;//the next position available moves back a space
                  return i; //returns the place the sheet was in
             }
       }   
       return -1;
    }
    
    public String remove(int index){
       if(index - 1 < nextPosition && nextPosition > 1){//checks for index inputted 
             sheets[index - 1] = temp;//puts sheet name in a temporary variable so it isn't lost
             for(j = nextPosition - 1; j > index; j--){//moves back sheets after the sheet removed
                   sheets[j-1] = sheets[j];
             }
             nextPosition--;
             return sheets[index];//returns sheetname removed
       }
       return "";    
    }
    
    public int move(String from, String to, boolean before){
        if(from != to){//checks that strings aren't the same
             for(i = 0; i < nextPosition; i++){//searches for from input
                    for(j = 0; j < nextPosition; j++){//searches for to input
                           if(sheets[i].compareToIgnoreCase(from) == 0 && sheets[j].compareToIgnoreCase(to) == 0){             
                                 if(before = true){//if boolean is true the sheet must go before to
                                      if(i < j){//checks if the sheet is before the to
                                          temp = sheets[i];// puts before sheet in a temp value
                                          for(k = i; k < j; k++){//all sheets after before sheet are moved back 1
                                              sheets[k] = sheets[k + 1];
                                          }
                                          sheets[j - 1] = temp;//sheet is then placed before to sheet
                                          return j;
                                      } else {
                                          temp = sheets[i];
                                          for(k = i; k >= j; k--){//before sheet is after to sheet 
                                              sheets[k] = sheets[k - 1];
                                              //sheets before i and after j are moved forward 1 space including j
                                          }
                                          sheets[j] = temp;
                                          return j + 1;
                                      } 
                                 } else {//boolean value dictacts that it must be after the to sheet
                                      if(i < j){//if sheet i is before j all sheets including j must be moved back a space
                                          temp = sheets[i];
                                          for(k = i; k <= j; k++){//all sheets more than i less than or equal to j moved                                           
                                              sheets[k] = sheets[k + 1];
                                          }
                                          sheets[j] = temp;
                                          return j + 2;
                                      } else {//if i is after j then all sheets before i and after j must be moved forward
                                          temp = sheets[i];
                                          for(k = i; k > j; k--){//sheets before i moved  
                                              sheets[k] = sheets[k - 1];
                                          }
                                          sheets[j + 1] = temp;
                                          return j + 3;
                                      }
                                 }                    
                           }
                    }
             }
        }
         return -1;
    }
    
    public String move(int from, int to, boolean before){
       if(from != to){
             for(i = 0; i < nextPosition; i++){//searches for "from" int
                    for(j = 0; j < nextPosition; j++){ //searches for "to" int
                           if((from - 1 == i) && (to - 1 == j)){//checks are sheets in the array as the index is 1 less than the input            
                                 if(before = true){
                                      if(i < j){
                                           temp = sheets[i];
                                           for(k = i; k < j; k++){
                                               sheets[k] = sheets[k + 1];
                                           }
                                           sheets[j - 1] = temp;
                                           return sheets[j];
                                      } else {
                                           for(k = i; k >= j; k--){
                                                sheets[k] = sheets[k - 1];
                                           }
                                           sheets[j] = temp;
                                           return sheets[j + 1];
                                        } 
                                 } else {
                                      if(i < j){
                                           for(k = i; k <= j; k++){
                                               sheets[k] = sheets[k + 1];
                                           }
                                           sheets[j] = temp;
                                           return sheets[j + 2];
                                      } else {
                                           for(k = i; k > j; k--){
                                               sheets[k] = sheets[k - 1];
                                           }
                                           sheets[j + 1] = temp;
                                           return sheets[j + 3];
                                      }
                                 }  
                           }
                    }
             }
       } 
       return "";
    }
    
    public String moveToEnd(int from){
       if(from > sheets.length){
             return null;
       } else {  
             for(i = from; i < sheets.length; i++){
                 sheets[sheets.length - 1] = sheets[from - 1]; //array.length-1 as the array.length gives an outofbounds exception     
             }
             return sheets[from - 1];
       }
    }
    
    public int moveToEnd(String from){
       
       int fromPos = 0;
       int count = 0;
       for(i = 0; i < sheets.length; i++){ //runs through names
            if(from.compareToIgnoreCase(sheets[i]) == 0){ //if names are  same
                  fromPos = i; // the position the array the names are same (i) becomes new var (fromPos
                  count++; 
                  for (i = fromPos; i < sheets.length; i++){
                        sheets[sheets.length - 1] = sheets[fromPos];                        
                  }                
            }                
       } 
       if (count > 0){
          return (fromPos); //this returns for example one = 0 two = 1 if it shoudl start with 1 do fromPos + 1 here
       } else {
          return - 1;
       }
    }
    
    public int rename(String currentName, String newName){
       for(i = 0; i < nextPosition; i++){//searches through array
             if(sheets[i].compareToIgnoreCase(currentName) == 0){//compares each sheet name to currentName
                 sheets[i] = newName;//sets any sheet named currentName to newName
                 return i;//returns index of String changed
             }
       }
       return -1; 
    }
    
    public int index(String sheetName){
       for(i = 0; i < nextPosition; i++){//searches through array
             if(sheets[i].compareToIgnoreCase(sheetName) == 0){//compares sheetName given to names in array
                 return i + 1;//returns index of sheet if found
             }
       }   
       return -1;
    }
    
    public String sheetName(int index){
       if(index - 1 < nextPosition){//checks if index position is being used
          return sheets[i];//returns the name of the sheet at that index
       }
       return ""; 
    }
    
    public void Display(){
        for(i = 0; i < nextPosition; i++){//goes through array from start to last position used
            System.out.println(sheets[i]);//prints each sheet name on the screen              
        }
    }
    
    public int length(){
        return nextPosition;// nextPosition = length of the array
    }
    
}
