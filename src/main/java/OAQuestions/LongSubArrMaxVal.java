package OAQuestions;
import java.util.HashMap;
public class LongSubArrMaxVal {
    static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;

        TreeNode(int val){
            this.val = val;
            left = null;
            right = null;
        }
    }


    public static int primeSumSubtrees(int n, int[][] edges) {
        TreeNode root = getTree(edges);
        int total = (int)(1e5 + 3) + 1;
        boolean primes[] = new boolean[total];
        primes[0] = true;
        primes[1] = true;

        for(int i = 2; i < total; i++){
            if(!primes[i]){
                int a = 2 * i;
                while(a < n + 1){
                    primes[a] = true;
                    a = a + i;
                }
            }
        }

        int count[] = new int[1];
        int sum = getSum(root, count, primes);
        return count[0];


    }
    private static int getSum(TreeNode root, int[] count, boolean[] primes){
        if(root == null){
            return 0;
        }
        int lst = getSum(root.left, count, primes);
        int rst = getSum(root.right, count, primes);
        int sum = (root.val + lst + rst) % ((int)1e5 + 3);
        if(!primes[sum]){
            count[0]++;
        }
        return sum;
    }

    private static TreeNode getTree(int edges[][]){
        HashMap<Integer, TreeNode> map = new HashMap<>();
        TreeNode root = new TreeNode(1);
        map.put(1, root);
        for(int i = 0; i < edges.length; i++){
            TreeNode child = new TreeNode(edges[i][1]);
            TreeNode parent = map.get(edges[i][0]);
            map.put(edges[i][1], child);
            if(parent.left == null){
                parent.left = child;
            }else{
                parent.right = child;
            }
        }
        return root;
    }

    private static void preorder(TreeNode node){
        if(node == null){
            return ;
        }
        System.out.println(node.val);
        preorder(node.left);
        preorder(node.right);
    }

    public static void main(String[] args) {
        int edges[][] = {{1,2}, {1,3}};
        TreeNode node = getTree(edges);
        preorder(node);

        int count = primeSumSubtrees(3, edges);
        System.out.println("Count : "+ count);
    }
}
