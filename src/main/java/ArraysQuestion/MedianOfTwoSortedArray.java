package ArraysQuestion;
//https://leetcode.com/problems/median-of-two-sorted-arrays/description/

public class MedianOfTwoSortedArray {
    //Brute Force T.C = O(N + M)  S.C = O(N + M)
    public static double findMedian1(int nums1[], int nums2[]){
        int merged[] = merged(nums1, nums2);
        if(merged.length % 2 == 0){
            return (merged[merged.length / 2 - 1] + merged[merged.length / 2])/2.0;
        }
        return merged[merged.length / 2] /  2.0;
    }
    private static int[] merged(int arr1[], int arr2[]){
        int l1 = arr1.length;
        int l2 = arr2.length;
        int merged[] = new int[l1 + l2];
        int i = 0;
        int j = 0;
        int k = 0;
        while(i < l1 && j < l2){
            if(arr1[i] < arr2[j]){
                merged[k] = arr1[i];
                i++;
            }else{
                merged[k] = arr2[j];
                j++;
            }
            k++;
        }
        while(i < l1){
            merged[k] = arr1[i];
            i++;
            k++;
        }
        while(j < l2){
            merged[k] = arr2[j];
            j++;
            k++;
        }
        return merged;
    }

    //Efficient - Binary Search
    public static double findMedian2(int[] nums1, int[] nums2) {

        if(nums2.length < nums1.length){
            return findMedian2(nums2, nums1);
        }
        int n1 = nums1.length;
        int n2 = nums2.length;
        int low = 0;
        int high = n1;
        while(low <= high){
            int cut1 = (low + high) / 2;
            int cut2 = (n1 + n2 + 1) / 2 - cut1;

            int l1 = (cut1 == 0)? Integer.MIN_VALUE: nums1[cut1 - 1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : nums2[cut2 - 1];

            int r1 = (cut1 == n1) ? Integer.MAX_VALUE : nums1[cut1];
            int r2 = (cut2 == n2) ? Integer.MAX_VALUE : nums2[cut2];

            if(l1 <= r2 && l2 <= r1){
                if((n1 + n2) % 2 == 0){
                    return (Math.max(l1,l2) + Math.min(r1,r2)) / 2.0;
                }else{
                    return (Math.max(l1, l2));
                }
            }
            else if(l1 > r2){
                high = cut1 - 1;
            }else{
                low = cut1 + 1;
            }
        }
        return 0.0;
    }
    public static void main(String[] args) {
        int arr1[] = {1,3,4,7,10,12};
        int arr2[] = {2,3,6,15};
        System.out.println("Brute Force : " + findMedian1(arr1, arr2));
        System.out.println("Efficient : " + findMedian2(arr1, arr2));
    }
}
