package OAQuestions;
//https://docs.google.com/document/d/1GHa5wUXQ46hVPEMzMYfY2gquEdvo1XQUyKoWDP-bm7A/edit
public class AmazonOAMinMaxInArr {
    public static void main(String[] args) {
        int arr[] = {7,5,1,9,1};
        int k = 25;
        System.out.println(getMinMax(arr, k));
    }
    private static int getMinMax(int arr[], int k){
        int low = getMax(arr);
        int high = low + k;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(check(arr, k, mid)){
                if(!check(arr, k, mid - 1)){
                    return mid;
                }
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }
        return -1;
    }
    private static boolean check(int arr[], int k, int g){
        int count = 0;
        for(int i = 0; i < arr.length; i++){
            count += g - arr[i];
        }
        return count >= k;
    }
    private static int getMax(int arr[]){
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] > max){
                max = arr[i];
            }

        }
        return max;
    }
}
