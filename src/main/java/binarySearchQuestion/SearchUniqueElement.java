package binarySearchQuestion;

public class SearchUniqueElement {
    public static void main(String[] args) {
        int arr[] = {1,1,2,2,3,3,4,4,5};
        System.out.println(getUniqueElement(arr));
    }
    private static int getUniqueElement(int arr[]){
        if(arr.length == 1) return arr[0];
        int low = 0;
        int high = arr.length - 1;
        while(low < high){
            int mid = low + (high - low)/2;
            if(mid > 0 && mid < arr.length - 2){
                if(arr[mid] != arr[mid - 1] && arr[mid] != arr[mid + 1]){
                    return arr[mid];
                }
            }
            //if its lie in left
            if(mid % 2 == 0){   // the first occurence of an element will be at even index and after unique eleemnt it changes.
                if(arr[mid] != arr[mid + 1]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }else{
                if(arr[mid] != arr[mid - 1]){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }

        }
        return arr[low];
    }
}
