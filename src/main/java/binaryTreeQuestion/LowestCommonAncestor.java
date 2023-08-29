package binaryTreeQuestion;

public class LowestCommonAncestor extends Tree{
    public static void main(String[] args) {

    }
    private TreeNode lca(TreeNode root, TreeNode p, TreeNode q){
        if(root == null || root == p|| root == q){
            return root;
        }

        TreeNode left = lca(root.left, p, q);
        TreeNode right = lca(root.right, p, q);
        if(left == null){
            return right;
        }else if(right == null){
            return left;
        }else{
            return root;
        }

    }
}
