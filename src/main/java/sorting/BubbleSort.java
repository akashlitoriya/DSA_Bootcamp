package sorting;

import java.util.*;
public class BubbleSort {

  public static void main(String[] args) {
        int array[] = {3,2,10,0,99,15,77};
        sort(array);
        System.out.println(Arrays.toString(array));
    }
     static void sort(int arr[]){
        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length - 1; j++){
                if(arr[j]  >  arr[j + 1]){
                    swap(arr[j], arr[j + 1]);
                }
            }
        }
    }
     static void swap(int p, int q){
      int temp = p;
       p = q;
       q = temp;
    }
}
