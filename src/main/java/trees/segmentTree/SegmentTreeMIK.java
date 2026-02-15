package trees.segmentTree;

import java.util.Arrays;

public class SegmentTreeMIK {
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 6, 9, 13};
        int n = arr.length;
        int[] tree = new int[2 * n + 2];
        buildTree(0, 0, n - 1, arr, tree);
        System.out.println("Segment Tree: " + Arrays.toString(tree));

        update(0, 0, n - 1, 2, 10, tree);
        System.out.println("Segment Tree after update: " + Arrays.toString(tree));

    }

    private static void buildTree(int i, int l, int r, int[] arr, int[] tree) {
        if (l == r) {
            tree[i] = arr[l];
            return;
        }
        int mid = l + (r - l) / 2;
        buildTree(2 * i + 1, l, mid, arr, tree);
        buildTree(2 * i + 2, mid + 1, r, arr, tree);
        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
    }

    private static void update(int i, int l, int r, int index, int value, int[] tree) {
        if (l == r) {
            tree[i] = value;
            return;
        }
        int mid = l + (r - l) / 2;
        if (index <= mid) {
            update(2 * i + 1, l, mid, index, value, tree);
        } else {
            update(2 * i + 2, mid + 1, r, index, value, tree);
        }
        tree[i] = tree[2 * i + 1] + tree[2 * i + 2];
    }
}
