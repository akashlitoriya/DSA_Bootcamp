package recursion;

public class Lecture1 {
    public static void main(String[] args) {
        //printNTimes(2);
        //printFirstN(10);
        System.out.println("Fibonacci : " + fibonacci(5));
        System.out.println("Factorial : " + factorial(5));
        int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12};
        System.out.println("Binary Search : " + recursiveBinarySearch(arr, 0, arr.length - 1, 13));
    }
    private static void printNTimes(int n){
        if(n == 0){
            return ;
        }
        System.out.println("Hello World !!!");
        printNTimes(n - 1);
    }
    private static void printFirstN(int n){
        if(n == 0){
            return ;
        }
        printFirstN(n - 1);
        System.out.println(n);
    }
    private static int fibonacci(int n){
        if(n <= 1){
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    private static int factorial(int n){
        if(n == 0){
            return 1;
        }
        return n * factorial(n - 1);
    }
    private static int recursiveBinarySearch(int arr[], int start, int end, int target){
        if(start > end){
            return -1;
        }
        int mid = start + (end - start) / 2;
        if(target == arr[mid]){
            return mid;
        }
        if(target > arr[mid]){
            return recursiveBinarySearch(arr, mid + 1, end, target);
        }
            return recursiveBinarySearch(arr, start, mid - 1, target);

    }
}
