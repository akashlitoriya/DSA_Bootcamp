package trees.segmentTree;
import trees.segmentTree.SegmentTreeProviderMIK;
public class RangeSumQuery {
    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 1, 0, 5, 6, 9};
        SegmentTreeProviderMIK segmentTree = new SegmentTreeProviderMIK(arr);
        int[][] queries = {{2, 6},{0, 3}, {2, 5}, {1, 6}};
        for (int[] query : queries) {
            int sum = rangeSumQuery(segmentTree.tree, 0, 0, (segmentTree.tree.length - 2) / 2, query[0], query[1]);
            System.out.println("Range Sum Query for [" + query[0] + ", " + query[1] + "] is: " + sum);
        }
    }

    private static int rangeSumQuery(int[] tree, int idx, int l, int r, int ql, int qr) {
        if (ql > r || qr < l) {
            // Out of bound scenario
            return 0;
        }

        if (ql <= l && qr >= r) {
            // entirely inside
            return tree[idx];
        }
        int mid = l + (r - l) / 2;
        int leftSum = rangeSumQuery(tree, 2 * idx + 1, l, mid, ql, qr);
        int rightSum = rangeSumQuery(tree, 2 * idx + 2, mid + 1, r, ql, qr);
        return leftSum + rightSum;
    }
}
