package stackAndQueueQuestions;

//https://leetcode.com/problems/largest-rectangle-in-histogram/

import java.util.Stack;

public class LargestRectangleHistogram {

    public static void main(String[] args) {
        int arr[] = {2,1,5,6,2,3};
        System.out.println("Max Area : " + largestRectangle(arr));
    }

    /*
    Naive Approach -
    TimeComplexity = O(N^2)
    SpaceComplexity = O(1)
     */
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for(int i = 0; i < heights.length; i++){
            int left = i;
            int right = i;
            while(left > -1 && heights[left] >= heights[i]){
                left--;
            }
            while(right < heights.length && heights[right] >= heights[i]){
                right++;
            }
            int area = (right - left - 1) * heights[i];
            if(area >= maxArea){
                maxArea = area;
            }
        }
        return maxArea;
    }

    /*
    Method - 2 : Using stack to find the prev smaller and next smaller using stack
     */

    public static int largestRectangle(int heights[]){
        int maxArea = 0;
        int ps[] = prevSmaller(heights);
        int ns[] = nextSmaller(heights);
        for(int i = 0; i < heights.length; i++){
            int currArea = (ns[i] - ps[i] - 1) * heights[i];
            maxArea = Math.max(maxArea, currArea);
        }
        return maxArea;
    }
    private static int[] prevSmaller(int a[]){
        int ps[] = new int[a.length];
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < a.length; i++){
            while(!s.isEmpty() && a[s.peek()] >= a[i]){
                s.pop();
            }
            if(s.isEmpty()){
                ps[i] = -1;
            }
            else{
                ps[i] = s.peek();
            }
            s.push(i);
        }
        return ps;
    }

    private static int[] nextSmaller(int a[]){
        int ns[] = new int[a.length];
        Stack<Integer> s = new Stack<>();
        for(int i = a.length - 1; i >= 0; i--){
            while(!s.isEmpty() && a[s.peek()] >= a[i]){
                s.pop();
            }
            if(s.isEmpty()){
                ns[i] = a.length;
            }
            else{
                ns[i] = s.peek();
            }
            s.push(i);
        }
        return ns;
    }

}
