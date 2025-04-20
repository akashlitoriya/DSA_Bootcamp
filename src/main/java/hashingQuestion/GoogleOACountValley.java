package hashingQuestion;

public class GoogleOACountValley {
    public static void main(String[] args) {
        int arr[] = {5,3,4,8,1,2,9,10,12,13};
        System.out.println(getNumberOfVallies(arr));
        int arr2[] = {5,3,4,8};
        System.out.println(getNumberOfVallies(arr2));
    }
    private static int getNumberOfVallies(int arr[]){
        int n = arr.length;
        int left[] = new int[n];
        int right[] = new int[n];
        //checking for each index i how many numbers are there that are strictly increasing
        int countLeft = 0;
        for(int i = 1; i < n; i++){
            if(arr[i - 1] > arr[i]){
                countLeft++;
            }else{
                countLeft = 0;
            }
            left[i] = countLeft;
        }

        int countRight = 0;
        for(int i = n - 2; i >= 0; i--){
            if(arr[i] < arr[i + 1]){
                countRight++;
            }else{
                countRight = 0;
            }
            right[i] = countRight;
        }

        int countVallies = 0;
        for(int i = 0; i < n; i++){
            if(left[i] != 0 && right[i] != 0){
                countVallies += left[i] * right[i];
            }
        }
        return countVallies;
    }

}
