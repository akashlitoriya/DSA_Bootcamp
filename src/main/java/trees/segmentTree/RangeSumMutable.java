package trees.segmentTree;

public class RangeSumMutable {
    int tree[];
    int size;
    public RangeSumMutable(int[] nums) {
        int n = nums.length;
        size = n;
        tree = new int[4 * n];
        build(0, 0, n - 1, nums);
    }

    public void update(int index, int val) {
        updateHelper(0, 0, size - 1, index, val);
    }
    private void updateHelper(int idx, int l, int r, int index, int val) {
        if (l == r) {
            tree[idx] = val;
            return;
        }
        int mid = l + (r - l) / 2;
        if (index <= mid) {
            updateHelper(2 * idx + 1, l, mid, index, val);
        } else {
            updateHelper(2 * idx + 2, mid + 1, r, index, val);
        }
        tree[idx] = tree[2 * idx + 1] + tree[2 * idx + 2];
    }

    public int sumRange(int left, int right) {
        return sumRangeHelper(0, 0, size - 1, left, right);
    }
    private int sumRangeHelper(int idx, int l, int r, int ql, int qr) {
        if (l > qr || r < ql) {
            return 0;
        }
        if (l >= ql && r <= qr) {
            return tree[idx];
        }
        int mid = l + (r - l) / 2;
        int left = sumRangeHelper( 2 * idx + 1, l, mid, ql, qr);
        int right = sumRangeHelper(2 * idx + 2, mid + 1, r, ql, qr);
        return left + right;
    }

    private void build(int idx, int l, int r, int[] arr) {
        if (l == r) {
            tree[idx] = arr[l];
            return;
        }
        int mid = l + (r - l) / 2;
        build(2 * idx + 1, l, mid, arr);
        build(2 * idx + 2, mid + 1, r, arr);
        tree[idx] = tree[2 * idx + 1] + tree[2 * idx + 2];
    }
}
