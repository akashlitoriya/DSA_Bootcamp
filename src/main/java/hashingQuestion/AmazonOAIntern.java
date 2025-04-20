package hashingQuestion;

public class AmazonOAIntern {
    public static void main(String[] args) {

        String s = "monomon";
        String t = "mon";
        System.out.println(getMaxRemoved(s, t));
        String s1 = "abacbc";
        String t1 = "bac";
        System.out.println(getMaxRemoved(s1, t1));
        String s2 = "abdadccacd";
        String t2 = "edac";
        System.out.println(getMaxRemoved(s2,t2));
    }
    private static int getMaxRemoved(String s, String t){
        int freqS[] = getFreq(s);
        int freqT[] = getFreq(t);
        int count = Integer.MAX_VALUE;
        for(int i = 0; i < t.length(); i++){
            int idx = (int)t.charAt(i) - 97;
            int del = freqS[idx]/freqT[idx];
            count = Math.min(count, del);
        }
        return count;
    }
    private static int[] getFreq(String str){
        int freq[] = new int[26];
        for(int i = 0; i < str.length(); i++){
            int idx = (int)str.charAt(i) - 97;
            freq[idx]++;
        }
        return freq;
    }
}
