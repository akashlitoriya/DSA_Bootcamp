package binarySearchQuestion;
import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximiseMiniArrayGoogleOA {
    static class Pair{
        int quantity;
        int cost;
        Pair(int quantity, int cost){
            this.quantity = quantity;
            this.cost = cost;
        }
    }
    public static void main(String[] args) {
        int a[] = {1, 99, 2, 99};
        int b[] = {1, 97, 2, 98};
        int c[] = {1, 5, 2, 2};
        System.out.println(Arrays.toString(getMaxMin(a, b, c)));
    }
    private static int[] getMaxMin(int a[], int b[], int c[]){
        int low = 0;
        int high = getMax(a);
        int minCost = Integer.MAX_VALUE;
        int minEle = Integer.MAX_VALUE;
        while(low <= high){
            int mid = low + (high - low) / 2;
            int temp[] = isPossible(a, b, c, mid);
            if(temp[0] == 1){
                minCost = Math.min(minCost, temp[1]);
                minEle = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return new int[]{minEle, minCost};
    }
    private static int[] isPossible(int a[], int b[], int c[], int k){
        int req = 0;
        int have = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((x,y)->x.cost - y.cost);
        for(int i = 0; i < a.length; i++){
            if(a[i] > k){
                int extra = a[i] - Math.max(b[i], k);
                have += extra;
                pq.add(new Pair(c[i], extra));
            }else{
                req += k - a[i];
            }
        }
        int ans[] = new int[2];
        if(have >= req){
            ans[0] = 1;
        }else{
            ans[0] = -1;
            return ans;
        }
        int cost = 0;
        while (req >= 1){
            if(req >= pq.peek().quantity){
                Pair ele = pq.poll();
                cost += ele.cost * ele.quantity;
                req -= ele.quantity;
            }else{
                Pair ele = pq.poll();
                cost += ele.cost * req;
                req = 0;
                pq.add(new Pair(ele.cost, ele.quantity - req));
            }
        }
        ans[1] = cost;
        return ans;
    }
    private static int getMax(int arr[]){
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }
        }
        return max;
    }
}
