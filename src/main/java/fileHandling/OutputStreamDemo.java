package fileHandling;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class OutputStreamDemo {
    public static void main(String[] args) {
        try(OutputStreamWriter out = new OutputStreamWriter(System.out)){
            out.write("Hello world");
            out.write(10);
            out.write(97);
            out.write("Akash Litoriya");
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
