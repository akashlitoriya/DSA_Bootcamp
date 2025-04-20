package binarySearchQuestion;
//https://docs.google.com/document/d/1hLi_sFb70XILSs-59La1NGZJ1yv8dfJ2VV5efnW-Xk0/edit?addon_store
public class MinDayChocoRubrikOA {
    public static void main(String[] args) {
        System.out.println(getMinDays(7));
    }
    private static int getMinDays(int n){
        int low = 1;
        int high = n;
        int ans = 0;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int max = getMax(mid);
            if(max >= n){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
    private static int getMax(int days){
        int g = days / 2;
        int g1 = days / 2;
        if(days % 2 == 1){
            g1++;
        }
        return g1 * (g + 1);
    }

}
