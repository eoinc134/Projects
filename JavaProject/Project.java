public class Project{
        private String[] sheets;
        private int nextPosition;
        private int i, j, k;
        private String temp;
        public Project(){
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
        public int remove (String sheetName){
            for(i=0; i< nextPosition; i++){ //for loop looks for sheet name and if statement checks if it is there
                if(sheets[i].compareToIgnoreCase(sheetName) == 0 && nextPosition>1){
                    for(j=nextPosition-1; j>i; j--){ //if the sheet is there all sheets after it are moved back 1 space
                        sheets[j-1] = sheets[j];
                    }
                    nextPosition--; // the next position available moves back a space
                    return i;   //returns the place the sheet was in
                }
            }   
                return -1;
        }
        
        public String remove(int index){
            if(index-1<nextPosition && nextPosition>1){ // checks for index inputted 
                sheets[index -1] = temp; // puts sheet name in a temporary variable so it isn't lost
                for(j=nextPosition-1; j>index; j--){ //moves back sheets after the sheet removed
                   sheets[j-1] = sheets[j];
                }
                nextPosition--;
                return temp; // returns sheetname removed
            }
            return "";    
        }
       
         public int move (String from, String to, boolean before){
                    if(from != to){ // checks that strings aren't the same
                      for (i=0; i<nextPosition; i++){ //searches for from input
                            for(j=0; j<nextPosition; j++){ //searches for to input
                                if(sheets[i].compareToIgnoreCase(from)==0 && sheets[j].compareToIgnoreCase(to)==0){             
                                   if(before == true){   // if boolean is true the sheet must go before to
                                        if (i<j){  // checks if the sheet is before the to
                                              temp = sheets[i];// puts before sheet in a temp value
                                            for(k=i; k<j; k++){ // all sheets after before sheet are moved back 1
                                                sheets[k] = sheets[k+1];
                                            }
                                            sheets[j-1] = temp; // sheet is then placed before to sheet
                                            return j;
                                        }  else{
                                            temp = sheets[i];
                                            for(k=i; k>=j; k--){   // before sheet is after to sheet 
                                                sheets[k] = sheets[k - 1];
                                                // sheets before i and after j are moved forward 1 space including j
                                            }
                                            sheets[j] = temp;
                                            return j+1;
                                        } 
                                   }   else{   //boolean value dictacts that it must be after the to sheet
                                       if (i<j){ //if sheet i is before j all sheets including j must be moved back a space
                                           temp = sheets[i];
                                           for(k=i; k<=j; k++){  //all sheets more than i less than or equal to j moved
                                               sheets[k] = sheets[k+1];
                                            }
                                            sheets[j] = temp;
                                            return j + 2;
                                        }else {  //if i is after j then all sheets before i and after j must be moved forward
                                            temp = sheets[i];
                                            for(k=i; k>j; k--){ //sheets before i moved
                                                sheets[k] = sheets[k-1];
                                            }
                                            sheets[j+1] = temp;
                                            return j + 3;
                                        }
                                    }   
                 
                                }
                            }
                         }
                    }
                    return -1;
                }
                
          public String move (int from, int to, boolean before){
                if(from != to){
                      for (i=0; i<nextPosition; i++){  //searches for "from" int
                            for(j=0; j<nextPosition; j++){ //searches for "to" int
                                if((from-1==i) && (to-1==j)){ //checks are sheets in the array as the index is 1 less than the input            
                                    if(before == true){
                                        if (i<j){
                                            temp = sheets[i];
                                            for(k=i; k<j; k++){
                                              sheets[k] = sheets[k+1];
                                            }
                                            sheets[j-1] = temp;
                                            return sheets[j];
                                        }  else {
                                            temp = sheets[i];
                                            for(k=i; k>=j; k--){
                                                sheets[k] = sheets[k-1];
                                            }
                                            sheets[j] = temp;
                                            return sheets[j+1];
                                        } 
                                   } else{
                                       if (i<j){
                                           temp = sheets[i];
                                           for(k=i; k<=j; k++){
                                               sheets[k] = sheets[k+1];
                                            }
                                            sheets[j] = temp;
                                            return sheets[j+2];
                                        } else {
                                            temp = sheets[i];
                                            for(k=i; k>j; k--){
                                                sheets[k] = sheets[k-1];
                                            }
                                            sheets[j+1] = temp;
                                            return sheets[j+3];
                                        }
                                    }  
                                }
                            }
                            }
                    }
                    return "";
                }
                public void Display(){
                    for(i=0; i < nextPosition; i++){
                    System.out.print(sheets[i]);
                    }
                }
            }
  
     
            
            
            
            
            
            
            
        
        
        
        
 
        







    
