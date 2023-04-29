package bstQuestion;
//https://leetcode.com/problems/delete-node-in-a-bst/

public class DeleteNodeBST {


    /*Delete Node, connect its right to the right of right most node in the LST
    T.C = O(Height)
    S.C = O(1)
    */
    public TreeNode deleteNode1(TreeNode root, int key) {
        if(root == null){
            return null;
        }
        TreeNode temp = root;
        if(temp.val == key){
            return delete(temp);
        }
        while(temp != null){
            if(temp.val < key){
                if(temp.right != null && temp.right.val == key){
                    temp.right = delete(temp.right);
                    break;
                }else{
                    temp = temp.right;
                }
            }else{
                if(temp.left != null && temp.left.val == key){
                    temp.left = delete(temp.left);
                    break;
                }else{
                    temp = temp.left;
                }
            }
        }
        return root;
    }
    private TreeNode delete(TreeNode root){
        if(root.left == null){
            root = root.right;
            return root;
        }else{
            TreeNode rst = root.right;
            root = root.left;
            TreeNode lstRight = rightMostLST(root);
            lstRight.right = rst;
        }
        return root;
    }
    private TreeNode rightMostLST(TreeNode root){
        if(root.right == null){
            return root;
        }
        while(root.right != null){
            root = root.right;
        }
        return root;
    }
    /*
    Delete Node and place inorder Successor in its place
     */
    public TreeNode deleteNode2(TreeNode root, int key){
        if(root == null){

        }
        return root;
    }

}
