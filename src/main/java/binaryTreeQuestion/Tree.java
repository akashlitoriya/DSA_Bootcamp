package binaryTreeQuestion;

public class Tree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val){
            this.val = val;
        }
        TreeNode(){
            this.val = 0;
            left = null;
            right = null;
        }
    }

    TreeNode root;
    static int idx = -1;
    private TreeNode getTreePreorder(Integer[] nodes){
        idx++;
        if(nodes[idx] == null){
            return null;
        }
        TreeNode node = new TreeNode(nodes[idx]);
        node.left = getTreePreorder(nodes);
        node.right = getTreePreorder(nodes);
        return node;
    }
    public TreeNode getTree(Integer[] nodes){
        return getTreeLevel(nodes, 0);
    }
    private TreeNode getTreeLevel(Integer[] nodes, int idx){
        TreeNode root = null;
        if(idx < nodes.length && nodes[idx] != null){
            root = new TreeNode(nodes[idx]);
            root.left = getTreeLevel(nodes, 2 * idx + 1);
            root.right = getTreeLevel(nodes, 2 * idx + 2);
        }
        return root;
    }



}
