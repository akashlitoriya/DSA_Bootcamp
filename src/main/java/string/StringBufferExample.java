package string;
import java.lang.StringBuffer;
public class StringBufferExample {
    public static void main(String[] args) {
        StringBuffer buffer = new StringBuffer();
        System.out.println("Initial capacity of Sting buffer : " + buffer.capacity());

        buffer.append("Akash Litoriya"); //add the provided string at the end of the buffer
        System.out.println("Buffer : " + buffer);

        //Converting stringBuffer to String
        String str = buffer.toString();
        System.out.println("Buffer to String : " + str);

        //Constructors of StingBuffer
        StringBuffer sb1 = new StringBuffer();
        StringBuffer sb2 = new StringBuffer("Akash");
        StringBuffer sb3 = new StringBuffer(30);

        //methods of stringbuffer
        sb2.append(" Litoriya");
        System.out.println("After Appending sb2 : " + sb2);

        sb2.insert(5, " litto");
        System.out.println("After insert method : " + sb2);

        sb2.delete(5,11);
        System.out.println("After deleting 5,11 : " + sb2);

        sb2.replace(0,5, "AKASH");
        System.out.println("After replacing 0,5 : " + sb2);
    }
}
