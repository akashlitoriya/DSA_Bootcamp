package fileHandling;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
public class FileDemo {
    public static void main(String[] args) {
        //creating a new file
        try{
            File file  = new File("new-file.txt");
            if(file.createNewFile()){
                System.out.println("File created successfully : " + file.getName());
            }else{
                System.out.println("Failed to create new file");
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        //writing in the file
        try(FileWriter fw = new FileWriter("new-file.txt")){
            fw.write("Writing in the file");
            fw.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        //Reading the data from file
        try(FileReader fr = new FileReader("new-file.txt")){
            int letter = fr.read();
            while(fr.ready()){
                System.out.print((char)letter);
                letter = fr.read();
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        //Deleting the file

    }
}
