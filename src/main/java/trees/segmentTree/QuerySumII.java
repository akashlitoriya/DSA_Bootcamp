package trees.segmentTree;

import java.util.Arrays;

public class QuerySumII {
    public static void main(String[] args) {
        int arr[] = {26, 30, 48, 29, 8};
        int q = 2;
        int queries[] = {4, 4, 2, 3};
        SegmentTreeProviderMIK segmentTree = new SegmentTreeProviderMIK(arr);
        int tree[] = segmentTree.tree;
        System.out.println(Arrays.toString(getQuerySum(q, queries, tree, arr)));
    }
    private static int[] getQuerySum(int q, int queries[], int[] tree, int[] arr) {
        int result[] = new int[q];
        for(int i = 0; i < 2 * q; i += 2) {
            result[i / 2] = getSum(0, 0, arr.length - 1, queries[i] - 1, queries[i + 1] - 1, tree);
        }
        return result;
    }
    private static int getSum(int idx, int l, int r, int st, int end, int[] tree) {
        if (l >= st && r <= end) {
            return tree[idx];
        }
        if (l > end || r < st) return 0;
        int mid = l + (r - l) / 2;
        int leftSum = getSum(2 * idx + 1, l, mid, st, end, tree);
        int rightSum = getSum(2 * idx + 2, mid + 1, r, st, end, tree);
        return leftSum + rightSum;
    }
}
