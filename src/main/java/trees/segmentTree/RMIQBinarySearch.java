package trees.segmentTree;
// https://leetcode.com/problems/find-building-where-alice-and-bob-can-meet/
public class RMIQBinarySearch {
    class Solution {
        int[] tree;
        public int[] leftmostBuildingQueries(int[] heights, int[][] queries) {
            int n = heights.length;
            tree = new int[4 * n];
            buildTree(0, 0, n-1, heights);
            int result[] = new int[queries.length];
            for(int i = 0; i < queries.length; i++) {
                result[i] = getQueryResult(heights, queries[i][0], queries[i][1]);
            }
            return result;
        }
        private int getQueryResult(int[] heights, int a, int b) {
            int maxIdx = Math.max(a, b);
            int minIdx = Math.min(a, b);
            if (heights[maxIdx] > heights[minIdx]){
                return maxIdx;
            } else if (maxIdx == minIdx) {
                return maxIdx;
            }
            int possibleResult = -1;
            int l = maxIdx + 1;
            int r = heights.length - 1;
            while (l <= r) {
                int mid = l + (r - l) / 2;
                int ans = RMIQ(0, 0, heights.length - 1, l, mid, heights);
                if (ans != -1 && checkIfValid(maxIdx, minIdx, ans, heights)) {
                    possibleResult = ans;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return possibleResult;
        }
        private void buildTree(int idx, int l, int r, int[] arr) {
            if (l == r) {
                tree[idx] = l;
                return;
            }
            int mid = l + (r - l) / 2;
            buildTree(2 * idx + 1, l, mid, arr);
            buildTree(2 * idx + 2, mid + 1, r, arr);
            int leftMaxIdx = tree[2 * idx + 1];
            int rightMaxIdx = tree[2 * idx + 2];
            if (arr[leftMaxIdx] > arr[rightMaxIdx]){
                tree[idx] = leftMaxIdx;
            } else {
                tree[idx] = rightMaxIdx;
            }
        }
        private int RMIQ(int idx, int l, int r, int ql, int qr, int[] arr) {
            if (l > qr || r < ql) {
                return -1;
            }
            if (l >= ql && r <= qr) {
                return tree[idx];
            }
            int mid = l + (r - l) / 2;
            int leftIdx = RMIQ(2 * idx + 1, l, mid, ql, qr, arr);
            int rightIdx = RMIQ(2 * idx + 2, mid + 1, r, ql, qr, arr);
            if (leftIdx == -1) return rightIdx;
            if (rightIdx == -1) return leftIdx;
            if (arr[leftIdx] > arr[rightIdx]) {
                return leftIdx;
            } else {
                return rightIdx;
            }
        }
        private boolean checkIfValid(int a, int b, int j, int[] arr) {
            return arr[j] > (Math.max(arr[a], arr[b]));
        }
    }
}
