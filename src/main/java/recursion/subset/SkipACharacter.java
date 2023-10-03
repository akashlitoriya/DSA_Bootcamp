package recursion.subset;

public class SkipACharacter {
    public static void main(String[] args) {
        String str = "baccad";
        System.out.println(skipCharacter(str, 'a'));
    }
    private static String skipCharacter(String str, char skip){
        if(str.length() == 0){
            return "";
        }
        String newStr;
        if(str.charAt(0) == skip){
            newStr = "";
        }else{
            newStr = "" + str.charAt(0);
        }
        String prev = skipCharacter(str.substring(1),skip);
        return newStr + prev;
    }
}
