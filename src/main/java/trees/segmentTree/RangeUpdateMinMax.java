package trees.segmentTree;

public class RangeUpdateMinMax {
    static int[] segMinTree;
    static int[] segMaxTree;
    static int[] lazy;
    private static void buildTree(int i, int l, int r, int nums[]) {
        if (l == r) {
            segMinTree[i] = nums[l];
            segMaxTree[i] = nums[l];
            return ;
        }

        int mid = l + (r - l)/2;
        buildTree(2 * i + 1, l, mid, nums);
        buildTree(2 * i + 2, mid + 1, r, nums);
        segMinTree[i] = Math.min(segMinTree[2 * i + 1], segMaxTree[2 * i + 2]);
        segMaxTree[i] = Math.max(segMaxTree[2 * i + 1], segMaxTree[2 * i + 2]);
    }

    private static void update(int i, int l, int r, int ql, int qr, int val) {
        if (lazy[i] != 0) {
            segMinTree[i] += lazy[i];
            segMaxTree[i] += lazy[i];
            if (l != r) {
                segMinTree[2 * i + 1] += lazy[i];
                segMaxTree[2 * i + 1] += lazy[i];
                segMinTree[2 * i + 2] += lazy[i];
                segMaxTree[2 * i + 2] += lazy[i];
            }
            lazy[i] = 0;
        }
        if (l > qr || r < ql) {
            return;
        }
        if (l >= ql && r <= qr) {
            segMaxTree[i] += val;
            segMinTree[i] += val;
            if (l != r) {
                lazy[2 * i + 1] += val;
                lazy[2 * i + 2] += val;
            }
            return;
        }
        int mid = l + (r - l) / 2;
        update(2 * i + 1, l, mid, ql, qr, val);
        update(2 * i + 2, mid + 1, r, ql, qr, val);
        segMinTree[i] = Math.min(segMinTree[2 * i + 1], segMinTree[2 * i + 2]);
        segMaxTree[i] = Math.max(segMaxTree[2 * i + 1], segMaxTree[2 * i + 2]);
    }

    public static void main(String[] args) {
        int arr[] = {4,1,2,3,9,0};
        int n = arr.length;
        segMinTree = new int[4 * n];
        segMaxTree = new int[4 * n];
        lazy = new int[4 * n];
        buildTree(0, 0, n - 1, arr);

    }
}
