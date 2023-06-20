package binarySearchQuestion;

import java.util.Scanner;

public class Sqrt {
    /* Using Binary Search T.C = log(N)*/
    public int mySqrt(int x) {
        int low = 0;
        int high = x;
        while(low <= high){
            int mid = (low +(high - low) / 2);
            long sqr = ((long)mid * mid);
            if(sqr == x){
                return mid;
            }else if(sqr < x){
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return high;
    }
    /* Using Linear Search  T.C. = O(N)*/
    public int sqrt(int x){
        int ans = 1;
        for(int i = 2; i < x; i++){
            if(i * i <= x){
                ans = i;
            }else{
                break;
            }
        }
        return ans;
    }

    /* Using Math.sqrt Function */
    public int sqrt3(int x){
        return (int)Math.sqrt(x);
    }

    public static void main(String[] args) {
        Sqrt obj = new Sqrt();
        Scanner in = new Scanner(System.in);
        System.out.print("Enter the number : ");
        int num = in.nextInt();
        System.out.println("Sqrt using binary search : " + obj.mySqrt(num));
        System.out.println("Sqrt using linear search : " + obj.sqrt(num));
        System.out.println("Sqrt using Math.sqrt : " + obj.sqrt3(num));
    }
}
