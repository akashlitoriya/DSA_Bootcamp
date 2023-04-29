package ArraysQuestion;

import java.util.Arrays;

public class MergeTwoSortedArray {
    /*
    Approach - 1: Using extra space
    T.C = O(n + m)
    S.C = O(n + m)
     */
    public int[] merge1(int[] arr1, int[] arr2){
        int i = 0;
        int j = 0;
        int k = 0;
        int n = arr1.length;
        int m = arr2.length;
        int merged[] = new int[n + m];
        while(i < n && j < m){
            if(arr1[i] < arr2[j]){
                merged[k] = arr1[i];
                i++;
            }else{
                merged[k] = arr2[j];
                j++;
            }
            k++;
        }
        while(i < n){
            merged[k] = arr1[i];
            i++;
            k++;
        }
        while(j < m){
            merged[k] = arr2[j];
            j++;
            k++;
        }
        return merged;
    }

    /*
    Approach - 2: Comparing Largest element of first and smallest of Second
    T.C = O(min(n,m)) + nlogn + mlogm
    S.C = O(1)
     */
    public void merge2(int[] arr1, int[] arr2){
        int n = arr1.length;
        int m = arr2.length;
        int left = n - 1;
        int right = 0;
        while(left >= 0 && right < m){
            if(arr1[left] > arr2[right]){
                swap(arr1, arr2, left, right);
            }else{
                break;
            }
            left--;
            right++;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }
    private void swap(int[] arr1, int[] arr2, int p, int q){
        int temp = arr1[p];
        arr1[p] = arr2[q];
        arr2[q] = temp;
    }
    /*Approach - 3: Using Gap Method
    T.C = O(log(n + m)) + O(n + m)
    S.C = O(1)
     */

    public void mergeSort3(int[] arr1, int[] arr2){
        int n = arr1.length;
        int m = arr2.length;
        int gap = (n + m) / 2 + (n + m) % 2;
        while(gap > 0){
            int left = 0;
            int right = left + gap;
            while(right < (n + m)){
                //arr1 and arr2 elements checked
                if(left < n && right >= n){
                    swapIfGreater(arr1, arr2, left, right);
                    left++;
                    right++;
                }
                //arr2 and arr2 elements checked
                else if(left >= n){
                    swapIfGreater(arr2, arr2, left - n, right - n);
                    left++;
                    right++;
                }
                //arr1 and arr1 elements are checked
                else{
                    swapIfGreater(arr1, arr1, left, right);
                    left++;
                    right++;
                }
            }
            if(gap == 1) break;
            gap = gap / 2 + gap % 2;
        }
    }
    private void swapIfGreater(int[] arr1, int[] arr2, int p, int q){
        if(arr1[p] > arr2[q]){
            int temp = arr1[p];
            arr1[p] = arr2[q];
            arr2[q] = temp;
        }
    }

}
