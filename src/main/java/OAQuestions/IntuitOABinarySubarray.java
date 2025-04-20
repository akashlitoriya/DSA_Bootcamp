package OAQuestions;

import java.util.HashMap;

//https://docs.google.com/document/d/1BPSKltnOGmp7e_lvytsjDi8xNQps_wOLw5UdsU2EJTs/edit
public class IntuitOABinarySubarray {
    public static void main(String[] args) {
        int arr[] = {0,1,0,1};
        int x = 1;
        int y = 1;
        System.out.println(getValidSubarrays(arr,x,y));
    }
    private static int getValidSubarrays(int arr[], int x, int y){
        int n = arr.length;
        int countOne = 0;
        int countSubArr = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; i++){
            if(arr[i] == 1){
                countOne++;
            }
            int countZero = i - countOne;
            int g = x * countOne - y * countZero;
            if(g == 0){
                countSubArr++;
            }
            if(map.containsKey(g)){
                countSubArr += map.get(g);
            }
            map.put(g, map.getOrDefault(g, 0) + 1);
        }
        return countSubArr;
    }

}
