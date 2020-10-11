
public class Profile
{
    private String name;
    private int age;
    private String location;
    
    public Profile(String name){
        this.name = name;
        this.age = 0;
        this.location = "";
    }
    public Profile(String name, int age, String location){
        this.name = name;
        this.age = age;
        this.location = location;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    public void setLocation(String location){
        this.location = location;
    }
    
    public void viewProfile(){
        System.out.println("NAME: " + this.name);
        System.out.println("AGE: " + this.age);
        System.out.println("LOCATION: " + this.location);
    }
}
