package OAQuestions;
//https://docs.google.com/document/d/1onMBbl-78nDM0grk5fYxR7EZ4jegWk3so3xQoTM-0p0/edit
public class MinMovesToReachDestGoogle {
    public static void main(String[] args) {
        System.out.println(getMinMoves(9));
    }
    private static int getMinMoves(int n){
        int d = getLeastD(n);
        if(check(n, d)){
            return d;
        }else if(check(n, d + 1)){
            return d + 1;
        }else if(check(n, d + 2)){
            return d + 2;
        }
        return -1;
    }
    private static boolean check(int n, int d){
        int diff = n - d * (d + 1) / 2;
        if(diff % 2 == 0){
            return true;
        }
        return false;
    }
    private static int getLeastD(int n){
        int low = 0;
        int high = n;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int sum = mid * (mid + 1) / 2;
            if(sum >= n){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return ans;
    }
}
