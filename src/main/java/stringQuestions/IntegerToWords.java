package stringQuestions;

public class IntegerToWords {
    private static String getInWords(int n){
        int count = 0;
        String[] extra = {"", " Thousand", " Million", " Billion"};
        String ans = "";
        while(n != 0){
            String str = getInt(n % 1000);
            if(count != 0 && str != ""){
                ans = extra[count]+ " " + ans;
            }

            ans = str + ans;
            n = n / 1000;
            count++;
        }
        return ans;
    }
    private static String getInt(int num){
        String ans = "";
        int time = 0;
        if(num/100 != 0){
            ans += getOnes(num/100) + " Hundred";
            time = num/100;
            time = time * 100;
            num = num % time;
        }
        if(num != 0 && num/10 != 0 && num/10 != 1){
            ans += " " + getTens(num/10);
            time = num / 10;
            time = time * 10;
            num = num % time;
        }else if(num != 0 && num / 10 == 1){
            num = num % 10;
            ans += " " +getTwenties(num);
            return ans;
        }
        if(num == 0) return ans;
        // time = num / 10;
        // time = time * 10;
        // num = num % time;
        if(num != 0){
            ans += " " + getOnes(num);
        }
        return ans;

    }
    private static  String getTens(int ten){
        String str[] = {"","","Twenty","Thirty","Forty","Fifty", "Sixty","Seventy","Eighty","Ninty"};
        return str[ten];
    }
    private static String getOnes(int one){
        String str[] = {"","One","Two","Three","Four","Five", "Six", "Seven", "Eight", "Nine"};
        return str[one];
    }
    private static String getTwenties(int twe){
        String str[] = {"Ten", "Eleven","Twelve", "Thirteen", "Forteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Ninteen"};
        return str[twe];
    }
}
