package jdbc;
import java.sql.*;
public class CreateTable {
    public static void main(String[] args) {
        try{
            //Load the Driver
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/myjdbc";
            String username = "root";
            String password = "Akashnarendra@10122000";
            //Creating connection
            Connection con = DriverManager.getConnection(url, username, password);
            //Running Query
            String q = "create table table1(tID int(20) primary key auto_increment, tName varchar(40), tAge int(20))";

            //Creating statement
            Statement stmt = con.createStatement();
            stmt.executeUpdate(q);
            System.out.println("Table Created");
            con.close();

        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
