import java.util.*;
public class GradeBook //extends StudentResult
{
    private String gradeBookName;
    private int numberOfTests;
    private ArrayList<StudentResult> results = new ArrayList<StudentResult>();
    
    public GradeBook(String name, int numberOfTests){
        this.gradeBookName = name;
        this.numberOfTests = numberOfTests;
        this.results = new ArrayList<StudentResult>();
    }
    
    public void addStudentResult(String id, int testID, double value){
        boolean found = false;
        for(int i = 0; i < this.results.size(); i++){
            if((this.results.get(i)).getStudentID() == id){
                (this.results.get(i)).addResult(testID, value);
                found = true;
            }
        }
        if(found == false){
            StudentResult student = new StudentResult(id, numberOfTests);
            student.addResult(testID, value);
            this.results.add(student);
        }
    }
    
    public String toString(){
        String listString = "";
        for (StudentResult s : this.results){
                listString += s + "\n";
        }
        return "GradeBook: " + gradeBookName + "\n" + listString;
    }
}
