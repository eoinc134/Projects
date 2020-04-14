public class ADriver{
    public static void main(String [] args){
        SpreadSheetTabs anInstance = new SpreadSheetTabs();
        
        //anInstance.add("sheetname");
        //anInstance.remove(index/sheetname);
        
        //anInstance.move(index/sheetname, index/sheetname, true/false);
        //anInstance.moveToEnd(index/sheetname);
        
        //anInstance.rename(old sheetname, new sheetname);
        
        //anInstance.index(sheetname);
        //anInstance.sheetName(index);
        
        //anInstance.Display();
        //anInstance.length();
        
        anInstance.add("");
        anInstance.remove("Sheet3");
        anInstance.add("");
        anInstance.rename("Sheet4", "wow");        
        anInstance.move(1, 3, true);
        anInstance.add("");
        //anInstance.moveToEnd("wow");
        
        //anInstance.moveToEnd(1);
        anInstance.Display();
    }
}
