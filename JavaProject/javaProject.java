 public class javaProject
{
    private String[] sheets;
    private int nextPosition;
    private int i, j, k;
    private String temp;
     public javaProject(){
       sheets = new String [256];
       nextPosition = 0;
    } 
    
    
    public boolean add(String sheetN){
       if (nextPosition<sheets.length){
             sheets[nextPosition] = new String(sheetN);
             nextPosition++;
             return true;
       }
       return false;
    }
    
    public int remove(String sheetName){
       for(i=0; i< nextPosition; i++){
             if(sheets[i].compareToIgnoreCase(sheetName) == 0 && nextPosition>1){
                  for(j=sheets.length-1; j>i; j--){
                        sheets[j-1] = sheets[j];
                  }
                  nextPosition--;
                  return i;
             }
       }   
       return -1;
    }
    
    public String remove(int index){
       if(index < nextPosition && nextPosition > 1){
             for(j=sheets.length-1; j> index; j--){
                   sheets[j-1] = sheets[j];
             }
             nextPosition--;
             return sheets[index];
       }
       return "";    
    }
    
    public int move(String from, String to, boolean before){
        return -1;
    }
    
    public String move(int from, int to, boolean before){
        return "";
    }
    
    public String moveToEnd(int from){
        return "";
    }
    
    public int moveToEnd(String from){
        return -1;
    }
    
    public int rename(String currentName, String newName){
        for(i = 0; i < nextPosition; i++){
            if(sheets[i].compareToIgnoreCase(currentName) == 0){
               sheets[i] = newName; 
               return i;
            }
        }
        return -1; 
    }
    
    public int index(String sheetName){
        for(i=0; i< nextPosition; i++){
             if(sheets[i].compareToIgnoreCase(sheetName) == 0){
                  return i;
             }
       }   
       return -1;
    }
    
    public String sheetName(int index){
        if(index<nextPosition){
          return sheets[i];   
        }
        return ""; 
    }
    
    public void Display(){
        for(i = 0; i < nextPosition; i++){
            System.out.println(sheets[i]);               
        }
    }
    
    public int length(){
        return nextPosition;
    }
    
}
