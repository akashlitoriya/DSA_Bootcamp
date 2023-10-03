package recursion;

public class Lecture2 {
    public static void main(String[] args) {
        System.out.println("Sum of N: " + sumOfN(10));
        System.out.println("Reverse : " + reverseNumber1(14569,0));
        System.out.println("Reverse : " + reverseNumber2(14569));
        System.out.println("Sum of Digits: " + sumOfDigits(14569,0));
        System.out.println("Product of Digits: " + productOfDigits(14569));
        System.out.println("Zeroes in 30204: " + countNumberOfZeroes(30204));
        int num[] = {1,2,3,3,4,1};
        System.out.println("Palindrome : " + palindrome(num,0,num.length - 1));
    }
    private static int sumOfN(int n){
        if(n == 0){
            return 0;
        }
        return n + sumOfN(n - 1);
    }
    private static int sumOfDigits(int n, int sum){
        if(n == 0){
            return sum;
        }
        sum += n % 10;
        return sumOfDigits(n / 10, sum);
    }
    private static int productOfDigits(int num){
        if(num % 10 == num){
            return num;
        }
        return num % 10 * productOfDigits(num / 10);
    }
    private static int reverseNumber1(int num, int rev){
        if(num == 0){
            return rev;
        }
        rev = rev*10 + num % 10;
        return reverseNumber1(num / 10, rev);
    }
    private static int reverseNumber2(int num){
        if(num % 10 == num) return num;
        int digits = (int) Math.log10(num) + 1;
        return reverseHelper(num, digits);
    }
    private static int reverseHelper(int num, int digits){
        if(num % 10 == num) return num;
        return num % 10 * (int)(Math.pow(10, digits - 1)) + reverseHelper(num / 10, --digits);
    }
    private static boolean palindrome(int num[], int s, int e){
        if(s > e) return true;
        if(num[s] != num[e]) return false;
        return palindrome(num, ++s, --e);
    }
    private static int countNumberOfZeroes(int num){
        if(num == 0){
            return 1;
        }
        return countNumberOfZeroesHelper(num, 0);
    }
    private static int countNumberOfZeroesHelper(int num, int count){
        if(num == 0){
            return count;
        }
        if(num % 10 == 0){
            count++;
        }
        return countNumberOfZeroesHelper(num / 10, count);
    }

}
