package binaryTreeQuestion;

import oops.oops5.interfaces.nested.A;

import java.util.*;

public class BoundaryOrderTraversal extends Tree{
    public static void main(String[] args) {
        BoundaryOrderTraversal obj = new BoundaryOrderTraversal();
        Integer nodes[] = {1,2,7,3,null,null,8,null,4,null,null,null,null,9,null,null,null,5,6,null,null,null,null,null,null,null,null,10,11};
        TreeNode root = obj.getTree(nodes);

        System.out.println(obj.getBoundary(root));
    }

    private ArrayList<Integer> getBoundary(TreeNode root){
        ArrayList<Integer> result = new ArrayList<>();
        if(root == null){
            return result;
        }
        leftBoundary(root, result);
        bottomBoundary(root, result);
        rightBoundary(root,result);
        return result;
    }

    private boolean isLeaf(TreeNode node){
        if(node.left == null && node.right == null){
            return true;
        }
        return false;
    }

    private void leftBoundary(TreeNode root, ArrayList<Integer> result){
        TreeNode curr = root;
        while(curr != null){
            if(!isLeaf(curr)) result.add(curr.val);
            if(curr.left != null){
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }
    }
    private void rightBoundary(TreeNode root, ArrayList<Integer> result){
        TreeNode curr = root;
        int size = result.size();
        while(curr != null){
            if(!isLeaf(curr)){
                result.add(size, curr.val);
            }
            if(curr.right != null){
                curr = curr.right;
            }else{
                curr = curr.left;
            }
        }
    }

    private void bottomBoundary(TreeNode root, ArrayList<Integer> result){
        if(isLeaf(root)){
            result.add(root.val);
            return;
        }
        if(root.left != null){
            bottomBoundary(root.left, result);
        }
        if(root.right != null){
            bottomBoundary(root.right, result);
        }

    }
}
