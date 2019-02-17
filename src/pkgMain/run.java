package pkgMain;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import pkgClass.*;

public class run {

    public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException, SQLException {
        /*
        Person p = new Person();
        p.age = 35;
        p.name = "igor";
        p.salary = 100500;
        p.dob = new java.util.Date();
        */
        
        List<Person> p_list = new ArrayList<Person>();
         
        Person p_new = new Person();
        
        Person p = new Person("igor",35,100500);
        Person p2 = new Person("anton",20,100500);
        p_list.add(p);
        p_list.add(p2);
        p.setAge(25);
        System.out.println("p = " + p + " get age: " + p.getAge());
        
        System.out.println(p.name +" "+ p.age +" "+ p.salary +" "+ p.dob);
        
        
        System.out.println(p_list.stream().filter(x -> "igor".equals(x.name)).count() + " igor obj");
        
        //List<Person> p_filter = p_list.stream().filter(x -> "igor".equals(x.name)).collect(Collectors.toList());
        //List<Person> p_filter = p_list.stream().filter(x -> (x.age<32)).collect(Collectors.toList());
         
        double totalSalary = p_list.stream().filter(x -> (x.age<22)).collect(Collectors.summingDouble(Person::getSalary));
        System.out.println("total salary = " + totalSalary);
        /// must remember
        
        BufferedReader br = new BufferedReader(new FileReader("/home/igor/data/test.txt"));
        String line = br.readLine();
        while(line!=null){
            System.out.println(line);
            line = br.readLine();
        }
        
        BufferedWriter bw = new BufferedWriter(new FileWriter("/home/igor/data/test.txt"));
        for (int i = 0; i < p_list.size(); i++) {
            bw.write(p_list.get(i).name + " " + p_list.get(i).age);
            bw.newLine();
        }
        
        bw.flush();
        bw.close();
        
        Student s = new Student("HSE","vasya",2);
        
        System.out.println(s.getAge2());
        
        System.out.println(s.getName2());
        System.out.println(s.getName());
        
        Connection con = getMySQL();
        
        ResultSet res = con.createStatement().executeQuery("select * from skillrankdb.developers");
        
        while(res.next()){
            System.out.println(res.getString("name"));
        }
        res.close();
        con.close();
        
        System.out.println("Done!");
    }
    
    public static Connection getMySQL() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");  
        Connection con=DriverManager.getConnection("jdbc:mysql://176.99.11.10","igor","igor123");  
        return con;
    }
    
}
