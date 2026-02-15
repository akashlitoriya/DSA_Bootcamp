package trees.segmentTree;

import java.util.Arrays;

public class RangeQueryMin {
    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 1, 0, 5, 6, 9};
        int[] tree = new int[4 * arr.length];
        buildTree(0, 0, arr.length - 1, arr, tree);
        System.out.println(Arrays.toString(tree));
        System.out.println(getMin(0, 0, arr.length - 1, 5,7, tree));
    }
    private static void buildTree(int idx, int l, int r, int[] arr, int[] tree) {
        if (l == r) {
            tree[idx] = arr[l];
            return;
        }
        int mid = l + (r - l) / 2;
        buildTree(2 * idx + 1, l, mid, arr, tree);
        buildTree(2 * idx + 2, mid + 1, r, arr, tree);
        tree[idx] = Math.min(tree[2 * idx + 1], tree[2 * idx + 2]);
    }
    public static int getMin(int idx, int l, int r, int ql, int qr, int tree[]) {
        if (l > qr || r < ql) return Integer.MAX_VALUE;
        if (l >= ql && r <= qr) {
            return tree[idx];
        }
        int mid = l + (r - l) / 2;
        int left = getMin(2 * idx + 1, l, mid, ql, qr, tree);
        int right = getMin(2 * idx + 2, mid + 1, r, ql, qr, tree);
        return Math.min(left, right);
    }
}
