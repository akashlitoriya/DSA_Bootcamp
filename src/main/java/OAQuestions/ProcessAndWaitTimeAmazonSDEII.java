package OAQuestions;

import java.util.ArrayList;
import java.util.HashMap;

public class ProcessAndWaitTimeAmazonSDEII {
    public static void main(String[] args) {
        int wait[] = {3,2,3,1,1,5};
        System.out.println(getProcessessAtT(wait));
    }
    private static ArrayList<Integer> getProcessessAtT(int wait[]){
        int n = wait.length;
        ArrayList<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int i = 0; i < n; i++){
            freq.put(wait[i], freq.getOrDefault(wait[i], 0) + 1);
        }
        int deleted = 0;
        ans.add(n);
        int time = 1; //for tracking the time
        int i = 0;  //for tracking the left most process
        while(time < n && i < n){
            while(i < n && wait[i] < time || i < n && freq.get(wait[i]) == 0){
                i++;
            }
            if(i < n && freq.get(wait[i]) > 0){
                deleted += 1;
                freq.put(wait[i], freq.get(wait[i]) - 1);
            }
            if(freq.containsKey(time)){
                deleted += freq.get(time);
            }
            ans.add(n - deleted);
            time++;
        }
        return ans;
    }
}
