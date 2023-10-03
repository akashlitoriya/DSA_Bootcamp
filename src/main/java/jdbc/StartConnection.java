package jdbc;
import java.sql.*;
public class StartConnection {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://localhost:3306/";

            String databaseName = "myjdbc";
            String userName = "root";
            String password = "Akashnarendra@10122000";

            Connection connection = DriverManager.getConnection(url,userName, password);

//            if(connection.isClosed()){
//                System.out.println("Connection is Closed...");
//            }else{
//                System.out.println("Connection Created...");
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
//C:\Program Files (x86)\MySQL\Connector J 8.0\mysql-connector-j-8.0.33