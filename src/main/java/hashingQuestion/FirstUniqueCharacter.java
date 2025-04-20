package hashingQuestion;

public class FirstUniqueCharacter {
    public static void main(String[] args) {
        String str = "loveleetcode";
        System.out.println(getFirstUnique(str));
    }
    private static int getFirstUnique(String str){
        int freq[] = new int[26];
        for(int i = 0; i < str.length(); i++){
            int idx = (int)str.charAt(i) - 97;
            freq[idx]++;
        }
        for(int i = 0; i < str.length(); i++){
            int idx = (int)str.charAt(i) - 97;
            if(freq[idx] == 1) return i;
        }
        return -1;
    }
}
