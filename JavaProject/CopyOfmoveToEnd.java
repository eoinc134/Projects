public class CopyOfmoveToEnd{
 public int CopyOfmoveToEnd(String from){
     String[] sheets = {"One", "Two", "Three", "Four", "Five", "Six", "Seven",
                       "Eight", "Nine", "Ten"};
                       
        int i = 0;  
        int fromPos = 0;
        int count = 0;
        for(i=0; i < sheets.length; i++){ //runs through names
            if(from.compareToIgnoreCase(sheets[i]) == 0){ //if names are  same
                fromPos = i; // the position the array the names are same (i) becomes new var (fromPos
                count++; 
                   for (i=fromPos; i < sheets.length; i++){
                        sheets[sheets.length-1] = sheets[fromPos];
                        
                    }
                
                }
                
        } if (count > 0){
        return (fromPos); //this returns for example one = 0 two = 1 if it shoudl start with 1 do fromPos + 1 here
    }else {
        return -1;
    }
    }
}