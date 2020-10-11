
public class MyDate
{
    private int day;
    private int month;
    private int year;
    
    public MyDate(){
        this.day = 1;
        this.month = 1;
        this.year = 2000;             
    }
    public MyDate(int d, int m, int y){
        this.day = d;
        this.month = m;
        this.year = y;
    }
    
    public String getDate(){
        return this.day + "/" + this.month + "/" + this.year;
    }
}
