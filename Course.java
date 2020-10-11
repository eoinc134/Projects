
public class Course
{
    private String courseName;
    private String[] students = new String[100];
    private int numberOfStudents = 0;
    
    public Course(String courseName){
        this.courseName = courseName;
    }
    
    public void addStudent(String studentName){
        this.students[numberOfStudents] = studentName;
        this.numberOfStudents++;
    }
    
    public String[] getStudents(){
        return this.students;
    }
    public int getNumberOfStudents(){
        return this.numberOfStudents;
    }
    public String getCourseName(){
        return this.courseName;
    }
}
