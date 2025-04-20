package hashingQuestion;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class GoldManSackDateFormater {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        String[] dates = new String[n];
        for(int i = 0; i < n; i++){
            dates[i] = bf.readLine();
        }
        System.out.println("OUTPUTS : ");
        for(String date: dates){
            System.out.println(getFormatedDate(date));
        }
    }
    private static String getFormatedDate(String date){
        HashMap<String, String> months = new HashMap<>();
        months.put("JAN", "01");
        months.put("FEB", "02");
        months.put("MAR", "03");
        months.put("APR", "04");
        months.put("MAY", "05");
        months.put("JUN", "06");
        months.put("JUL", "07");
        months.put("AUG", "08");
        months.put("SEP", "09");
        months.put("OCT", "10");
        months.put("NOV", "11");
        months.put("DEC", "12");

        String[] data = date.split(" ");
        String day = "";
        if(data[0].charAt(1) >= 'a' && data[0].charAt(1) <= 'z'){
            day += "0" + data[0].charAt(0);
        }else{
            day += data[0].substring(0,2);
        }
        String month = months.get(data[1]);
        String year = data[2];
        String ans = year +"-"+ month +"-"+ day;
        return ans;
    }
}
