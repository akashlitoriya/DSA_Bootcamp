package binarySearchQuestion;
//refer docs for the code

public class MaxServerBNYMellonOA {
    public static void main(String[] args) {
        int ns[] = {4,3};
        int money[] = {8,9};
        int sell[] = {4,2};
        int upgrade[] = {9,5};
        System.out.println(getMaxServerUpgrade(ns, money, upgrade, sell));
    }
    private static int getMaxServerUpgrade(int ns[], int money[], int upgrade[], int sell[]){
        int count = 0;
        for(int i = 0; i < ns.length; i++){
            count += solve(ns[i], money[i], upgrade[i], sell[i]);
        }
        return count;
    }
    private static int solve(int server, int money, int upgrade, int sell){
        int low = 0;
        int high = server;
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            boolean check = check(mid, server, money, upgrade, sell);
            if(check){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        System.out.println(ans);
        return ans;
    }
    private static boolean check(int k, int num_ser, int money, int upgrade, int sell){
        int rem = num_ser - k;
        int have = money + k * sell;
        int req = rem * upgrade;
        if(have >= req) return true;
        return false;
    }
}
