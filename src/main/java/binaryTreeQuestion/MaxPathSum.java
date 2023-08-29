package binaryTreeQuestion;

public class MaxPathSum extends Tree{
    public static void main(String[] args) {
        MaxPathSum obj = new MaxPathSum();
        Integer nodes[] = {-10,9,20,null,null,15,7};
        TreeNode root = obj.getTree(nodes);
        System.out.println(obj.maxPathSum(root));
    }
    public int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        int sum[] = new int[1];
        sum[0] = Integer.MIN_VALUE;
        int path = getMaxPath(root, sum);
        return sum[0];
    }
    private int getMaxPath(TreeNode root, int[] max){
        if(root == null){
            return 0;
        }

        int left = Math.max(0,getMaxPath(root.left, max));
        int right = Math.max(0,getMaxPath(root.right, max));

        max[0] = Math.max(left + right + root.val, max[0]);
        return Math.max(left, right) + root.val;
    }
}
