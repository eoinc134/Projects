import java.util.*;
public class TestResult
{
    int numberOfTests;
    double[] scores;
    
    public TestResult(){
        this.numberOfTests = 3;
        this.scores = new double[numberOfTests];
    }
    public TestResult(int numberOfTests){
        this.numberOfTests = numberOfTests;
        this.scores = new double[numberOfTests];
    }
    
    public void gradeTable(){
        System.out.println("A1- 80");
        System.out.println("A2- 72");
        System.out.println("B1- 64");
        System.out.println("B2- 60");
        System.out.println("B3- 56");
        System.out.println("C1- 52");
        System.out.println("C2- 48");
        System.out.println("C3- 40");
        System.out.println("D1- 35");
        System.out.println("D2- 30");
        System.out.println("F - 1");
        System.out.println("NG- 0");
    }
    
    public void setScore(int i, double value){
        this.scores[i - 1] = value;
    }
    public double getScore(int i){
        return this.scores[i - 1];
    }
    
    public double getAverage(){
        double average = 0;
        int count = 0;
        for(int i = 0; i < numberOfTests; i++){
           if(this.scores[i] == 0.0){
               count++;
            }
           average += this.scores[i];           
        }
        return average / (numberOfTests - count);
    }
    public double getTotal(){
        double total = 0;
        for(int i = 0; i < numberOfTests; i++){
           total += scores[i];
        }
        return total;
    }
    public String getGrade(){
        double score = getAverage();        
        if(score >= 80){
            return "A1";
        } else if(score >= 72){
            return "A2";
        } else if(score >= 64){
            return "B1";
        } else if(score >= 60){
            return "B2";
        } else if(score >= 56){
            return "B3";
        } else if(score >= 52){
            return "C1";
        } else if(score >= 48){
            return "C2";
        } else if(score >= 40){
            return "C3";
        } else if(score >= 35){
            return "D1";
        } else if(score >= 30){
            return "D2";
        } else if(score >= 1){
            return "F";
        } else if(score == 0){
            return "NG";
        }
        return "Invalid Score";
    }
    
    public String toString(){
        return "Results: " + Arrays.toString(scores) + ", Average: " + getAverage() + ", Grade: " + getGrade();
    }
}
