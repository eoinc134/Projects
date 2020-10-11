
public class Rectangle
{
    private double height;
    private double width;
    
    public Rectangle(){
        this.height = 1.0;
        this.width = 1.0;
    }
    
    public Rectangle(double height, double width){
        this.height = height;
        this.width = width;
    }
    
    public double getHeight(){
        return this.height;
    }
    public double getWidth(){
        return this.width;
    }    
    
    public double getPerimeter(){                
        return 2 * (this.width + this.height);
    }
    public double getArea(){
        return this.height * this.width;
    }
}
