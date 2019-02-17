package pkgClass;

public class Student extends Person {
    public String university;
    
    public Student(String x, String y,int z){
        this.university = x;
        super.name = y;
        super.age = z;
    }
}
