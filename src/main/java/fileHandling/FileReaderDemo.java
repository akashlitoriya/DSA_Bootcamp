package fileHandling;

import java.io.FileReader;
import java.io.IOException;

public class FileReaderDemo {
    public static void main(String[] args) {
        try(FileReader file = new FileReader("C:\\Users\\DELL\\IdeaProjects\\DSA Bootcamp\\src\\main\\java\\fileHandling\\name.txt")){
            int letter = file.read();
            while(file.ready()){
                System.out.print((char)letter);
                letter = file.read();
            }
            file.close();
        }
        catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
