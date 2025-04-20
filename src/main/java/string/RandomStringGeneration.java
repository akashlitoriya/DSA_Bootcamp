package string;
import java.util.Random;
public class RandomStringGeneration {
    public static String getRandomString(int len){
        StringBuffer str = new StringBuffer(len);
        for(int i = 0; i < len; i++){
            int random = (int)(Math.random() * 101) % 26;
            char ch = (char)(97 + random);
            str.append(ch);
        }
        return str.toString();
    }

    public static void main(String[] args) {
        System.out.println("Random String len 5 : " + getRandomString(5));
        System.out.println("Random String  : " + getRandomString(20));
    }
}
