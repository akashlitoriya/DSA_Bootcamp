package ArraysQuestion;
import java.util.*;
public class AddtoArrayForm {

    public List<Integer> addToArrayForm(int[] num, int k) {
        if(k == 0){
            ArrayList<Integer> ans = new ArrayList<>();
            for(int item : num){
                ans.add(item);
            }
            return ans;
        }
        if(num.length == 0){
            ArrayList<Integer> ans = new ArrayList<>();
            for(int item : toArray(k)){
                ans.add(item);
            }
            return ans;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        int kArr[] = toArray(k);
        int carry = 0;
        int i = 0;
        int m = num.length;
        int n = kArr.length;
        while((m - i - 1) >= 0 && (n - i - 1) >= 0){
            int sum = num[m - i - 1] + kArr[n - i - 1] + carry;
            if(sum > 9){
                ans.add(0,sum % 10);
                carry = 1;
            }else{
                ans.add(0, sum);
                carry = 0;
            }
            i++;
        }
        while((m - i - 1) >= 0){
            int sum = num[m - i - 1] + carry;
            if(sum > 9){
                ans.add(0,sum % 10);
                carry = 1;
            }else{
                ans.add(0, sum);
                carry = 0;
            }
            i++;
        }
        while((n - i - 1) >= 0){
            int sum = kArr[n - i - 1] + carry;
            if(sum > 9){
                ans.add(0,sum % 10);
                carry = 1;
            }else{
                ans.add(0, sum);
                carry = 0;
            }
            i++;
        }
        if(carry == 1){
            ans.add(0, 1);
        }

        return ans;
    }
    private int[] toArray(int n){
        int arr[] = new int[countdigit(n)];
        int i = countdigit(n) - 1;
        while(n != 0){
            arr[i] = n % 10;
            n = n / 10;
            i--;

        }
        return arr;
    }
    private int countdigit(int n){
        if(n == 0){
            return 1;
        }
        int count = 0;
        while(n != 0){
            n = n/10;
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int num[] = {2,7,4};
        int k = 181;
        AddtoArrayForm obj = new AddtoArrayForm();
        obj.addToArrayForm(num,k);
    }
}
