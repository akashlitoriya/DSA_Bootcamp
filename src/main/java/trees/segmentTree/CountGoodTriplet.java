package trees.segmentTree;
import java.util.HashMap;
public class CountGoodTriplet {
    private void updateTree(int i, int l, int r, int idx, int[] segmentTree) {
        if (l == r) {
            segmentTree[i] = 1;
            return ;
        }
        int mid = l + (r - l) / 2;
        if (idx <= mid) {
            updateTree(2 * i + 1, l, mid, idx, segmentTree);
        } else {
            updateTree(2 * i + 2, mid + 1, r, idx, segmentTree);
        }
        segmentTree[i] = segmentTree[2 * i + 1] + segmentTree[2 * i + 2];
    }
    private long queryTree(int i, int ql, int qr, int l, int r, int[] segmentTree) {
        if (l > qr || r < ql) {
            return 0;
        }
        if (l >= ql && r <= qr) {
            return segmentTree[i];
        }
        int mid = l + (r - l) / 2;
        long leftResult = queryTree(2 * i + 1, ql, qr, l, mid, segmentTree);
        long rightResult = queryTree(2 * i + 2, ql, qr, mid + 1, r, segmentTree);
        return leftResult + rightResult;
    }
    public long goodTriplets(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int segmentTree[] = new int[4 * n];

        HashMap<Integer, Integer> map = new HashMap<>();  //Store index of y in nums2
        for(int i = 0; i < n; i++) {
            map.put(nums2[i], i);
        }

        //Now mark the index of nums1[0] as visited.
        updateTree(0, 0, n - 1, map.get(nums1[0]), segmentTree);

        long tripletCount = 0;
        // iterate on nums1
        for(int i = 1; i < n - 1; i++) {
            int idx = map.get(nums1[i]);
            long leftCommonCount = queryTree(0, 0, idx, 0, n - 1, segmentTree);
            long leftUncommonCount = i - leftCommonCount;
            long elementAfterIdxNums2 = n - idx - 1;
            long rightCommonCount = elementAfterIdxNums2 - leftUncommonCount;
            tripletCount += (long)(leftCommonCount * rightCommonCount);
            updateTree(0, 0, n - 1, idx, segmentTree);
        }
        return tripletCount;
    }
}
