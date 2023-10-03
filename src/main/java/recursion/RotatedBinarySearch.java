package recursion;

public class RotatedBinarySearch {
    private static int rotatedBS(int num[],int s, int e, int target){
        if(s > e){
            return -1;
        }
        int mid = s + (e - s) /2;
        if(num[mid] == target) return mid;
        if(num[s] <= num[mid]){
            if(target >= num[s] && target <= num[mid]){
                return rotatedBS(num, s, mid - 1, target);
            }else{
                return rotatedBS(num, mid + 1, e, target);
            }
        }
        if(target >= num[mid] && target <= num[e]){
            return rotatedBS(num, mid  + 1, e, target);
        }
        return rotatedBS(num, s, mid - 1, target);

    }

    public static void main(String[] args) {
        int num[] = {7,8,10,19,34,1,3,4,5,6};
        int target = 8;
        System.out.println(rotatedBS(num, 0, num.length - 1, target));
    }
}
