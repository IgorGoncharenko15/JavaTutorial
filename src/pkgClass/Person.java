package pkgClass;

public class Person extends PersonAbstr implements PersonInterface{
    public double salary;
    public java.util.Date dob;
    
    
    
    public Person(){
        
    }
    
    public Person(String x, int y, double z){
        this.name = x;
        this.age = y;
        this.salary = z;
    }
    
    public int getAge(){
        return this.age;
    }
    
    public void setAge(int x){
        this.age = x;
    }

    public double getSalary(){
        return this.salary;
    }
    
    @Override
    public int getAge2(){
        return age*age;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getName2() {
        return this.name + this.name;
    }
}
