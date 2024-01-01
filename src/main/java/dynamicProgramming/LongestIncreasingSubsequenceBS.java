package dynamicProgramming;
import java.util.*;
public class LongestIncreasingSubsequenceBS {
    public static void main(String[] args) {

    }
    private int getLIS(int arr[]){
        ArrayList<Integer> temp = new ArrayList<>();
        int n = arr.length;
        int len = 1;
        temp.add(arr[0]);
        for(int i = 1; i < n; i++){
            if(arr[i] > temp.get(len - 1)){
                len++;
                temp.add(arr[i]);
            }else{
                int lowerBound = lowerbound(temp, arr[i]);
                if(temp.get(lowerBound) != arr[i]){
                    //temp.remove(lowerBound);
                    temp.set(lowerBound, arr[i]);
                }
            }
        }
        return len;
    }
    private int lowerbound(ArrayList<Integer> arr, int target){
        int st = 0;
        int end = arr.size() - 1;
        while(st < end){
            int mid = st + (end - st) / 2;
            if(arr.get(mid) == target){
                return mid;
            }else if(arr.get(mid) < target){
                st = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return st;
    }
}
