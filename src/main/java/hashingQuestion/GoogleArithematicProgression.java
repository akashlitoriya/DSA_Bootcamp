package hashingQuestion;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class GoogleArithematicProgression {
    public static void main(String[] args) {
        int[] arr = {5, 8, 8, 10, 11, 12};
        System.out.println(getSubarraySum(arr));
        System.out.println(optimized(arr));
    }
    private static int optimized(int arr[]){
        int sum = 0;

        HashMap<Integer,Pair<Integer, Integer>> prev = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            int count = 0;
            int temp = 0;
            if(prev.containsKey(arr[i] - 1)){
                temp = prev.get(arr[i] - 1).getKey();
                count = prev.get(arr[i] - 1).getValue();

            }

            if(prev.containsKey(arr[i])){
                temp += prev.get(arr[i]).getKey();
                count += prev.get(arr[i]).getValue();
            }

            sum += temp + arr[i] * (count + 1);

            if(prev.containsKey(arr[i])){
                count += prev.get(arr[i]).getValue();
                temp += prev.get(arr[i]).getKey();
                prev.put(arr[i], new Pair<>(temp, count + 1));
            }else{
                prev.put(arr[i], new Pair<>(temp, count));
            }
        }
        return sum;

    }
    private static int getSubarraySum(int arr[]){
        int sum = 0;
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            ArrayList<Integer> subarr = new ArrayList<>();
            subarr.add(arr[i]);
            if(map.containsKey(arr[i] - 1)){
                ArrayList<Integer> temp = map.get(arr[i] - 1);
                for(int j = 0; j < temp.size(); j++){
                    subarr.add(temp.get(j) + arr[i]);
                    sum += temp.get(j) + arr[i];
                }

            }
            if(map.containsKey(arr[i])){
                ArrayList<Integer> temp = map.get(arr[i]);
                for(int j = 0; j < temp.size(); j++){
                    subarr.add(temp.get(j) + arr[i]);
                    sum += temp.get(j) + arr[i];
                }
            }

            if(map.containsKey(arr[i])){
                subarr.addAll(map.get(arr[i]));
                map.put(arr[i], subarr);
            }else{
                map.put(arr[i], subarr);
            }
        }
        return sum;
    }
}
