package binaryTree;

public class BinaryTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
    }
    static class Tree_Build{
        static int idx = -1;
        static TreeNode build(int[] arr){
            idx++;
            if(arr[idx] == -1){
                return null;
            }
            TreeNode newNode = new TreeNode(arr[idx]);
            newNode.left = build(arr);
            newNode.right = build(arr);
            return newNode;
        }
    }
}
