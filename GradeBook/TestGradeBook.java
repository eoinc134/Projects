
public class TestGradeBook
{
    public static void main(String[] args){
        GradeBook cs4013 = new GradeBook("CS4013", 4);
        GradeBook cs4023 = new GradeBook("CS4023", 3);
        
        cs4013.addStudentResult("Eoin", 1, 100);
        cs4013.addStudentResult("Eoin", 2, 45);
        cs4013.addStudentResult("David", 3, 76);
        cs4013.addStudentResult("David", 4, 8);
        
        cs4023.addStudentResult("Sean", 1, 90);
        cs4023.addStudentResult("Andrew", 2, 45);
        cs4023.addStudentResult("Leon", 3, 55);
        
        System.out.println(cs4013.toString());
        System.out.println(cs4023.toString());
    }
}
