
public class QuadraticFormula
{
   private int a;
   private int b;
   private int c;
   
   public QuadraticFormula(int a, int b, int c){
       this.a = a;
       this.b = b;
       this.c = c;
       
       solution(a, b, c);
   }
   
   public void setA(int a){
       this.a = a;
    }    
   public int getA(int a){
       return this.a;
   }
    
   public void setB(int b){
       this.b = b;
   }
   public int getB(int b){
       return this.b;
   } 
   
   public void setC(int c){
       this.c = c;
   }
   public int getC(int c){
       return this.c;
    }
    
   public String solution(int a, int b, int c){
       int FOURac = 4 * a * c;
       int squareB = b * b;
       int squareRoot = squareB - FOURac;
       int TWOa = 2 * a;
       
       int solution1 = squareRoot - b;
       int solution2 = squareRoot + b;
       
       solution1 = solution1 / TWOa;
       solution2 = solution2 / TWOa;
       
       String solution = ("x = " + solution1 + " or " + solution2);
       
       return solution;
   }
}
