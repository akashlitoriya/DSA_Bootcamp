package jdbc;
import java.io.FileInputStream;
import java.sql.*;
public class InsertingImageIntoTable {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/myjdbc","root","Akashnarendra@10122000");
            //Creating Table
            String q1 = "create table table2(imgID int(10) primary key auto_increment, image blob)";
            Statement stmt = con.createStatement();
            stmt.executeUpdate(q1);

            //Inserting image into the table
            String q2 = "insert into table2(image) value(?)";
            //Getting image using FileInputStream
            FileInputStream fileImage = new FileInputStream("D:\\world map.jpg");
            //Passing data
            PreparedStatement pstmt = con.prepareStatement(q2);
            pstmt.setBinaryStream(1, fileImage);
            //Executing query
            pstmt.executeUpdate();

            System.out.println("Image Added SuccessFully....");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
