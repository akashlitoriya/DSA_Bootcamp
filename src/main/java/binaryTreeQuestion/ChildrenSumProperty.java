package binaryTreeQuestion;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
public class ChildrenSumProperty extends Tree{
    public static void main(String[] args) {
        ChildrenSumProperty obj = new ChildrenSumProperty();
        Integer nodes[] = {40, 10, 20, 2, 5, 30, 40};
        TreeNode root = obj.getTree(nodes);
        System.out.println("Before Conversion : "+ obj.getLevelOrder(root));
        obj.getChildrenSumTree(root);
        System.out.println("After Conversion : " + obj.getLevelOrder(root));

    }
    private ArrayList<ArrayList<Integer>> getLevelOrder(TreeNode root){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                level.add(node.val);
                if(node.left != null) q.offer(node.left);
                if(node.right != null) q.offer(node.right);

            }
            ans.add(level);
        }
        return ans;
    }
    private void getChildrenSumTree(TreeNode root){
        if(root == null) return;

        int childSum = 0;
        if(root.left != null) childSum += root.left.val;
        if(root.right != null) childSum += root.right.val;

        if(root.val < childSum){
            root.val = childSum;
        }else{
            if(root.left != null) root.left.val = root.val;
            if(root.right != null) root.right.val = root.val;
        }

        getChildrenSumTree(root.left);
        getChildrenSumTree(root.right);

        int leftPlusRight = 0;
        if(root.left != null) leftPlusRight += root.left.val;
        if(root.right != null) leftPlusRight += root.right.val;

        if(root.left != null || root.right != null) root.val = leftPlusRight;
    }
}
