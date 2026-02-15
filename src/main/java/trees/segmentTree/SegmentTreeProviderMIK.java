package trees.segmentTree;

public class SegmentTreeProviderMIK {
    int[] tree;
    SegmentTreeProviderMIK(int[] arr) {
        int n = arr.length;
        this.tree = new int[4 * n];
        buildTree(0, 0, n - 1, arr);
    }

    private void buildTree(int idx, int l, int r, int[] arr) {
        if (l == r) {
            tree[idx] = arr[l];
            return;
        }

        int mid = l + (r - l) / 2;
        buildTree(2 * idx + 1, l, mid, arr);
        buildTree(2 * idx + 2, mid + 1, r, arr);
        tree[idx] = tree[2 * idx + 1] + tree[2 * idx + 2];
    }

    protected void update(int idx, int value) {
        updateHelper(0, 0, (tree.length - 2) / 2, idx, value);
    }
    private void updateHelper(int idx, int l, int r, int index, int value) {
        if (l == r) {
            tree[idx] = value;
            return;
        }
        int mid = l + (r - l) / 2;
        if (index <= mid) {
            updateHelper(2 * idx + 1, l, mid, index, value);
        } else {
            updateHelper(2 * idx + 2, mid + 1, r, index, value);
        }
        tree[idx] = tree[2 * idx + 1] + tree[2 * idx + 2];
    }

}
