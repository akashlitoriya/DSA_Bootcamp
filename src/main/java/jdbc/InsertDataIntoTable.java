package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDataIntoTable {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try{
            //Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/myjdbc";
            String username = "root";
            String password = "Akashnarendra@10122000";
            //Creating connection
            Connection con = DriverManager.getConnection(url, username, password);
            //Running Query
            String q = "insert into table1(tName, tAge) values (?, ?)";

            //Creating statement
            PreparedStatement stmt = con.prepareStatement(q);
//            System.out.println("Enter Name : ");
//            String name = in.next();
//            stmt.setString(1,name);
//            System.out.println("Enter Age : ");
//            int age = in.nextInt();
//            stmt.setInt(2, age);
//            stmt.executeUpdate();

            System.out.println("Row Added Successfully....");

            stmt.setString(1,"Aditi Jain");
            stmt.setInt(2,21);
            stmt.executeUpdate();
            System.out.println("Row Added Successfully");

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
