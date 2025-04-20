package fileHandling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriteDemo {
    public static void main(String[] args) {
        try(FileWriter file = new FileWriter("C:\\Users\\DELL\\IdeaProjects\\DSA Bootcamp\\src\\main\\java\\fileHandling\\name.txt")){
            file.write("Hello cutieeeee");
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        try(FileWriter file = new FileWriter("C:\\Users\\DELL\\IdeaProjects\\DSA Bootcamp\\src\\main\\java\\fileHandling\\name.txt", true)){
            file.write("\nFirse hello cutieee, par bina kisi or ki jagah liye huye");
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        try(BufferedWriter bf = new BufferedWriter(new FileWriter("C:\\Users\\DELL\\IdeaProjects\\DSA Bootcamp\\src\\main\\java\\fileHandling\\name.txt", true))){
            bf.write("\nHello sweatyyyy");

        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
