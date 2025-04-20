package OAQuestions;
import java.util.Arrays;
//https://docs.google.com/document/d/1cUYKbpG1Xi_VvVtZYQlZ4paRVhh5mUg9QYQNXk4GKlo/edit
public class LongestSubseqScoreDeShawOA {
    public static void main(String[] args) {
        int a[] = {4,3,2,1};
        int m = 33;
        System.out.println(getLongest(a, m));
    }
    private static int getLongest(int arr[], int m){
        int n = arr.length;
        int low = 1;
        int high = n;
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low) / 2;
            boolean check = check(arr, mid, m);
            if(check){
                if(!check(arr, mid + 1, m)){
                    return mid;
                }
                ans = mid;
                low  = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans;
    }
    private static boolean check(int arr[], int k, int m){
        int b[] = new int[arr.length];
        for(int i = 0; i < arr.length; i++){
            b[i] = (i + 1) * k + arr[i];
        }
        Arrays.sort(b);
        int i = 0;
        int score = 0;
        while(i < k){
            score += b[i];
            i++;
        }
        if(score <= m){
            return true;
        }
        return false;
    }

}
