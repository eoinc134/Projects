import java.util.*;
public class StudentResult extends TestResult
{
    private String studentID;
    private int numberOfTests;
    private TestResult testResult;
    
    public StudentResult(String studentID){
        this.studentID = studentID;
        this.numberOfTests = 3;
        this.testResult = new TestResult();
    }
    public StudentResult(String studentID, int numberOfTests){                
        this.studentID = studentID; 
        this.numberOfTests = numberOfTests;
        this.testResult = new TestResult(numberOfTests);
    }
    
    public String getStudentID(){
        return this.studentID;
    }
    
    public void addResult(int testID, double value){
        this.testResult.setScore(testID, value);
    }
    
    public String toString(){                        
        String score = "";
        for(int i = 1; i <= numberOfTests; i++){
            score += testResult.getScore(i) + ", ";
        }       
        return "Student: " + studentID + " , Results: " + score + "Grade: " + testResult.getGrade();
    }
}
