 
public class assignment{
 public String moveToEnd(int from){
     String[] array = {"One", "Two", "Three", "Four", "Five", "Six", "Seven",
                       "Eight", "Nine", "Ten"};
                       
int i;
                       
    if(from > array.length){
    return null;
}
                       
  else{  
     for(i=from; i < array.length; i++){
         array[array.length -1] = array[from - 1]; //array.length-1 as the array.length gives an outofbounds exception
         
        }
     
     
     return array[from -1];
}
    
    }
}
