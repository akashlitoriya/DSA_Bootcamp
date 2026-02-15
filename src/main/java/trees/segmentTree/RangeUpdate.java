package trees.segmentTree;

public class RangeUpdate {
    static int tree[];
    static int lazy[];
    public static void main(String[] args) {
        int arr[] = {3, 4, 2, 5, 3, 6, 3, 4};
        tree = new int[4 * arr.length];
        lazy = new int[4 * arr.length];
        buildTree(0, 0, arr.length - 1, arr);
        int queries[][] = {{1, 2, 3, 0}, {2, 0, 1, 3}, {2, 2, 4, 1}, {1, 1, 5, 0}};
    }
    public static void buildTree(int idx, int l, int r, int[] arr) {
        if (l == r) {
            tree[idx] = arr[l];
        }

        int mid = l + (r - l) / 2;
        buildTree(2 * idx + 1, l, mid, arr);
        buildTree(2 * idx + 2, mid + 1, r, arr);
        tree[idx] = tree[2 * idx + 1] + tree[2 * idx + 2];
    }

    public static int getSum(int idx, int l, int r, int ql, int qr, int val) {
        // Lazy propagation
        if (lazy[idx] != 0) {
            tree[idx] = tree[idx] + (r - l + 1) * val;
            if (l != r) {
                lazy[2 * idx + 1] += lazy[idx];
                lazy[2 * idx + 2] += lazy[idx];
            }
            lazy[idx] = 0;
        }

        // Now start finding update range
        // outbound
        if (l > qr || r < ql) {
            return tree[idx];
        }
        if (l >= ql && r <= qr) {
            // update value
            tree[idx] += tree[idx] + (r - l + 1) * val;
            if (l != r) {
                lazy[2 * idx + 1] = val;
                lazy[2 * idx + 2] = val;
            }
            return tree[idx];
        }

        int mid = l + (r - l + 1) / 2;
        getSum(2 * idx + 1, l, mid, ql, qr, val);
        getSum(2 * idx + 2, mid, r, ql, qr, val);
        tree[idx] = tree[2 * idx + 1] + tree[2 * idx + 2];
        return tree[idx];
    }

}
