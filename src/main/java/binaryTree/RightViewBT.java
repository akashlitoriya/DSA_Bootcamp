package binaryTree;
import trees.BuildTreePreorder;

import java.util.Queue;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class RightViewBT extends BinaryTree {
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();

        if(root == null){
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            TreeNode temp = q.peek();
            for(int i = 0; i < size; i++){
                if(q.peek().left != null){
                    q.add(q.peek().left);
                }
                if(q.peek().right != null){
                    q.add(q.peek().right);
                }
                //temp = q.peek();
                q.poll();
            }

            ans.add(temp.val);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] tree = {1,2,-1,5,-1,-1,3,-1,4,-1,-1};
        RightViewBT treeBuild = new RightViewBT();
        TreeNode root = BinaryTree.Tree_Build.build(tree);
        List<Integer> rsv = rightSideView(root);
        System.out.println(rsv);
    }
}
