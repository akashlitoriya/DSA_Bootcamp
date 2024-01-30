package fileHandling;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class BufferReaderDemo {
    public static void main(String[] args) {
        //byte to character stream and then reading the character stream
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))){
            System.out.println("You typed: " + bf.readLine());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        //reading character stream from a file
        try(BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\DELL\\IdeaProjects\\DSA Bootcamp\\src\\main\\java\\fileHandling\\name.txt"))){
            while(bf.ready()){
                System.out.println(bf.readLine());
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
