package CSESProblemSet.range_queries;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RangeUpdateSum {
    static long segTree[];
    static int lazyType[];
    static long lazyVal[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String firstLine[] = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0] );
        int q = Integer.parseInt(firstLine[1] );
        int nums[] = new int[n];
        String strEle[] = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(strEle[i]);
        }
        segTree = new long[4 * n];
        lazyType = new int[4 * n];
        lazyVal = new long[4 * n];
        buildTree(0, 0, n - 1, nums);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken()) - 1;
            int r = Integer.parseInt(st.nextToken()) - 1;
            int val = 0;
            if (type != 3) {
                val = Integer.parseInt(st.nextToken());
            }
            if (type == 3) {
                sb.append(getSum(0, 0, n - 1, l, r));
                sb.append("\n");
            } else if (type == 1) {
                increaseVal(0, 0, n - 1, l, r, val);
            } else {
                updateVal(0, 0, n - 1, l, r, val);
            }
        }
        System.out.println(sb.toString());
    }

    private static void buildTree(int idx, int l, int r, int[] arr) {
        if (l == r) {
            segTree[idx] = arr[l];
            return;
        }
        int mid = l + (r - l) / 2;
        buildTree(2 * idx + 1, l, mid, arr);
        buildTree(2 * idx + 2, mid + 1, r, arr);
        segTree[idx] = segTree[2 * idx + 1] + segTree[2 * idx + 2];
    }
    private static long getSum(int idx, int l, int r, int ql, int qr) {
        lazyUpdate(idx, l, r);
        if (l > qr || r < ql) {
            return 0;
        }
        if (l >= ql && r <= qr) {
            return segTree[idx];
        }
        int mid = l + (r - l) / 2;
        long leftSum = getSum(2 * idx + 1, l, mid, ql, qr);
        long rightSum = getSum(2 * idx + 2, mid + 1, r, ql, qr);
        // segTree[idx] = leftSum + rightSum;
        return leftSum + rightSum;
    }
    private static void updateVal(int idx, int l, int r, int ql, int qr, int val){
        lazyUpdate(idx, l, r);
        if (l > qr || r < ql) {
            return;
        }
        if (l >= ql && r <= qr) {
            segTree[idx] = (long)(r - l + 1) * val;
            if (l != r) {
                updateLazyNode(2 * idx + 1, 2, val);
                updateLazyNode(2 * idx + 2, 2, val);
            }
            return;
        }
        int mid = l + (r - l) / 2;
        updateVal(2 * idx + 1, l, mid, ql, qr, val);
        updateVal(2 * idx + 2, mid + 1, r, ql, qr, val);
        segTree[idx] = segTree[2 * idx + 1] + segTree[2 * idx + 2];
    }
    private static void increaseVal(int idx, int l, int r, int ql, int qr, int val) {
        lazyUpdate(idx, l, r);
        if (l > qr || r < ql) {
            return;
        }
        if (l >= ql && r <= qr) {
            segTree[idx] += (long)(r - l + 1) * val;
            if (l != r) {
                updateLazyNode(2 * idx + 1, 1, val);
                updateLazyNode(2 * idx + 2, 1, val);
            }
            return;
        }
        int mid = l + (r - l) / 2;
        increaseVal(2 * idx + 1, l, mid, ql, qr, val);
        increaseVal(2 * idx + 2, mid + 1, r, ql, qr, val);
        segTree[idx] = segTree[2 * idx + 1] + segTree[2 * idx + 2];
    }
    private static void lazyUpdate(int idx, int l, int r) {
        int type = lazyType[idx];
        if (type != 0) {
            if (type == 1) {
                segTree[idx] += (r - l + 1) * lazyVal[idx];
            } else {
                segTree[idx] = (r - l + 1) * lazyVal[idx];
            }
            if (l != r) {
                // update Left child
                updateLazyNode(2 * idx + 1, type, lazyVal[idx]);
                // update right child
                updateLazyNode(2 * idx + 2, type, lazyVal[idx]);
            }
            lazyType[idx] = 0; // reset lazy update
        }

    }
    private static void updateLazyNode(int idx, int type, long val) {
        int currType = lazyType[idx];
        if (currType == 0) {
            lazyType[idx] = type;
            lazyVal[idx] = val;
            return;
        }
        if (currType == 1) {
            if (type == 1) {
                lazyVal[idx] += val;
            } else {
                lazyType[idx] = type;
                lazyVal[idx] = val;
            }
        } else {
            if (type == 1) {
                lazyVal[idx] += val;
            } else {
                lazyVal[idx] = val;
            }
        }
    }
}
