package hashingQuestion;

public class ArcesiumOAStringTwin {
    public static void main(String[] args) {
        String[][] str = {{"cdab", "dcba"}, {"abcd", "abcd"}};
        for(int i = 0; i < str.length; i++){
            if(checkStringTwin(str[i][0], str[i][1])){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
    private static boolean checkStringTwin(String a, String b){
        int n = a.length();
        int m = b.length();
        if(n != m) return false;
        int[] freqEvenA = new int[26];
        int[] freqEvenB = new int[26];
        int[] freqOddA = new int[26];
        int[] freqOddB = new int[26];
        for(int i = 0; i < n; i++){
            if(i % 2 == 0){
                int idxA = a.charAt(i) - 'a';
                int idxB = b.charAt(i) - 'a';
                freqEvenA[idxA]++;
                freqEvenB[idxB]++;
            }else{
                int idxA = a.charAt(i) - 'a';
                int idxB = b.charAt(i) - 'a';
                freqOddA[idxA]++;
                freqOddB[idxB]++;
            }
        }
        return compareFreq(freqEvenA, freqEvenB) && compareFreq(freqOddA, freqOddB);
    }
    private static boolean compareFreq(int a[], int b[]){
        for(int i = 0; i < 26; i++){
            if(a[i] != b[i]) return false;
        }
        return true;
    }
}
