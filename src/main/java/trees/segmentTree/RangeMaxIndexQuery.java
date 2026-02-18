package trees.segmentTree;

public class RangeMaxIndexQuery {
    static int tree[];
    public static void main(String[] args) {
        int arr[] = {1,7, 6, 9, 2, 3};
        int n = arr.length;
        tree = new int[4 * n];
        buildTree(0, 0, n - 1, arr);
        System.out.println(getMinIdx(0, 0, n - 1, 4, 5, arr));

    }
    private static void buildTree(int idx, int l, int r, int[] arr) {
        if (l == r){
            tree[idx] = l;
            return;
        }
        int mid = l + (r - l) / 2;
        buildTree(2 * idx + 1, l, mid, arr);
        buildTree(2 * idx + 2, mid + 1, r, arr);
        int leftMaxIdx = tree[2 * idx + 1];
        int rightMaxIdx = tree[2 * idx + 2];
        if (arr[leftMaxIdx] > arr[rightMaxIdx]) {
            tree[idx] = leftMaxIdx;
        } else {
            tree[idx] = rightMaxIdx;
        }
    }
    private static int getMinIdx(int idx, int l, int r, int ql, int qr, int[] arr) {
        if (l > qr || r < ql) return -1;
        if (l >= ql && r <= qr) {
            return tree[idx];
        }
        int mid = l + (r - l) / 2;
        int leftMaxIdx = getMinIdx(2 * idx + 1, l, mid, ql, qr, arr);
        int rightMaxIdx = getMinIdx(2 * idx + 2, mid + 1, r, ql, qr, arr);
        if (leftMaxIdx == -1) return rightMaxIdx;
        if (rightMaxIdx == -1) return leftMaxIdx;
        if (arr[leftMaxIdx] > arr[rightMaxIdx]) {
            tree[idx] = leftMaxIdx;
        }  else {
            tree[idx] = rightMaxIdx;
        }
        return tree[idx];
    }
}
