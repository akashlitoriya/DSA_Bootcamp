package stringQuestions;

public class RomanToInteger {
    public int romanToInt(String s) {
        int num = 0;
        int idx = 0;
        int nextValue = 0;
        while(idx < s.length()){
            int value = getValue(s.charAt(idx));
            if(idx != s.length() - 1){
                nextValue = getValue(s.charAt(idx + 1));
                if(nextValue > value){
                    nextValue = nextValue - value;
                    value = nextValue;
                    idx = idx + 1;
                }
            }
            num = num + value;
            idx++;
        }
        return num;
    }
    private int getValue(char ch){
        int value = 0;
        switch(ch){
            case 'M':
                value = 1000;
                break;
            case 'D':
                value = 500;
                break;
            case 'C':
                value = 100;
                break;
            case 'L':
                value = 50;
                break;
            case 'X':
                value = 10;
                break;
            case 'V':
                value = 5;
                break;
            case 'I':
                value = 1;
                break;
            default:

        }
        return value;
    }

    public static void main(String[] args) {
        RomanToInteger obj = new RomanToInteger();
        String s = "XIV";
        System.out.println(obj.romanToInt(s));
    }
}
