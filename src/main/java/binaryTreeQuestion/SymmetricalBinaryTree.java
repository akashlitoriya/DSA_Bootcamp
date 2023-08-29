package binaryTreeQuestion;

public class SymmetricalBinaryTree extends Tree{
    public static void main(String[] args) {
        SymmetricalBinaryTree obj = new SymmetricalBinaryTree();
        Integer nodes[] = {1,2,2,3,4,4,5};
        TreeNode root = obj.getTree(nodes);
        System.out.println(obj.symmetrical(root));
    }
    private boolean symmetrical(TreeNode root){
        if(root == null){
            return false;
        }
        return isSymmetrical(root.left, root.right);
    }
    private boolean isSymmetrical(TreeNode left, TreeNode right){
        if(left == null || right == null){
            return left == right;
        }

        if(left.val != right.val) return false;

        return isSymmetrical(left.left, right.right) && isSymmetrical(left.right, right.left);
    }
}
