package fileHandling;

import java.io.IOException;
import java.io.InputStreamReader;

public class InputStreamDemo {

    public static void main(String[] args) {
        try(InputStreamReader isr = new InputStreamReader(System.in)){
            System.out.print("Enter a number: ");
            int n = isr.read();
            while(isr.ready()){
                System.out.print((char)n);
                n = isr.read();
            }
            isr.close();
        }catch(IOException e){
            System.out.println(e.getMessage());
        }
    }
}
