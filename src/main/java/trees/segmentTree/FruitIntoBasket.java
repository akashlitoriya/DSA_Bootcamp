package trees.segmentTree;

public class FruitIntoBasket {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        int segmentTree[] = new int[4 * n];
        buildMaxTree(0, 0, n - 1, segmentTree, baskets);
        int unplaced = 0;
        for(int i = 0; i < n; i++) {
            if(getMaxQuery(0, 0, n - 1, fruits[i], segmentTree)) {
                continue;
            }
            unplaced++;
        }
        return unplaced;
    }
    private void buildMaxTree(int i, int l, int r, int[] segmentTree, int[] arr) {
        if (l == r) {
            segmentTree[i] = arr[l];
            return;
        }
        int mid = l + (r - l) / 2;
        buildMaxTree(2 * i + 1, l, mid, segmentTree, arr);
        buildMaxTree(2 * i + 2, mid + 1, r, segmentTree, arr);
        segmentTree[i] = Math.max(segmentTree[2 * i + 1], segmentTree[2 * i + 2]);
    }
    private boolean getMaxQuery(int i, int l, int r, int query, int[] segmentTree) {
        if (segmentTree[i] < query) {
            return false;
        }
        if (l == r) {
            segmentTree[i] = -1;
            return true;
        }
        boolean isPlaced = false;
        int mid = l + (r - l) / 2;
        if (segmentTree[2 * i + 1] >= query) {
            isPlaced = getMaxQuery(2 * i + 1, l, mid, query, segmentTree);
        } else {
            isPlaced = getMaxQuery(2 * i + 2, mid + 1, r, query, segmentTree);
        }
        segmentTree[i] = Math.max(segmentTree[2 * i + 1], segmentTree[2 * i + 2]);
        return isPlaced;
    }
}
