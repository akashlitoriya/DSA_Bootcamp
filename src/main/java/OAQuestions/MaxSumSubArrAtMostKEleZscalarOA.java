package OAQuestions;

import java.util.PriorityQueue;
//https://docs.google.com/document/d/1BUjcHa_TgZ-iHfRVpEleZYK8XdQgM_kiPEegPoq_GKY/edit
public class MaxSumSubArrAtMostKEleZscalarOA {
    static class Pair{
        int sum;
        int idx;
        Pair(int sum, int idx){
            this.sum = sum;
            this.idx = idx;
        }
    }

    private static int getMaxSubArraySum(int arr[], int k){
        int maxi = Integer.MIN_VALUE;
        int sum = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.sum - b.sum);
        for(int i = 0; i < arr.length; i++){
            sum += arr[i];
            if(!pq.isEmpty() && pq.peek().idx >= i - k){
                int subArrSum = sum - pq.peek().sum;
                maxi = Math.max(maxi,subArrSum);
            }else{
                pq.poll();
            }
            maxi = Math.max(maxi, arr[i]);
            pq.add(new Pair(sum, i));
        }
        return maxi;
    }

    public static void main(String[] args) {
        int arr[] = {5,-10,8,4,-10,100,-10};
        int k = 3;
        System.out.println(getMaxSubArraySum(arr, k));
    }
}
