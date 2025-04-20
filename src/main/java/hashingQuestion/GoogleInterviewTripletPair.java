package hashingQuestion;

public class GoogleInterviewTripletPair {
    public static void main(String[] args) {

    }
    private static int getValidTriplets(int arr[]){
        int n = arr.length;
        int prefix[] = new int[n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[i]) prefix[i]++;
            }
        }
        int suffix[] = new int[n];
        for(int j = n - 1; j >= 0; j--){
            for(int k = j + 1; k < n; k++){
                if(arr[k] > arr[j]) suffix[j]++;
            }
        }

        int count = 0;
        for(int i = 0; i < n; i++){
            count += prefix[i] * suffix[i];
        }
        return count;
    }
}
