package binaryTreeQuestion;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class MInimumTimeToBurnTree extends Tree{
    public static void main(String[] args) {

    }
    private HashMap<TreeNode, TreeNode> getParent(TreeNode root){
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left != null){
                q.offer(node.left);
                parent.put(node.left, node);
            }
            if(node.right != null){
                q.offer(node.right);
                parent.put(node.right, node);
            }
        }
        return parent;
    }

    private int findTimeToBurn(TreeNode root, TreeNode target){
        int time = 0;
        if(root == null) return -1;
        HashMap<TreeNode, TreeNode> parent = getParent(root);
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        q.offer(target);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0; i < size; i++){
                TreeNode curr = q.poll();
                visited.put(curr, true);
                if(curr.left != null && !visited.containsKey(curr.left)){
                    q.offer(curr.left);
                }
                if(curr.right != null && !visited.containsKey(curr.right)){
                    q.offer(curr.right);
                }
                if(parent.containsKey(curr) && !visited.containsKey(parent.get(curr))){
                    q.offer(parent.get(curr));
                }
            }
            time++;
        }
        return time;
    }
}
