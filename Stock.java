
public class Stock
{
    private String symbol;
    private String name;
    private double previousClosingPrice;
    private double currentPrice;
    
    public Stock(String symbol, String name){
        this.symbol = symbol;
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
    
    public String getChangePercent(double previuos, double current){
        double change = current - previuos;        
        if(change > 0){
            return String.format("+ %.2f %n", change);
        } else if(change < 0) {
            return String.format("- %.2f %n", change);
        }
        
        return "+0.0";
    }
}
