package binaryTreeQuestion;

import java.util.*;

public class NodesAtKDistance extends Tree{
    public static void main(String[] args) {
        NodesAtKDistance obj = new NodesAtKDistance();
        Integer nodes[] = {3,5,1,6,2,0,8,null,null,7,4,null,null};
        TreeNode root = obj.getTree(nodes);
        TreeNode target = new TreeNode(5);

    }
    private TreeMap<TreeNode, TreeNode> getParent(TreeNode root){
        TreeMap<TreeNode, TreeNode> parentPointers = new TreeMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(curr.left != null){
                parentPointers.put(curr.left, curr);
                q.add(curr.left);
            }
            if(curr.right != null){
                parentPointers.put(curr.right, curr);
                q.add(curr.right);
            }

        }
        return parentPointers;
    }

    private ArrayList<Integer> findNodeAtK(TreeNode root, int k, TreeNode target){
        ArrayList<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        TreeMap<TreeNode, TreeNode> parent = getParent(root);

        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        q.offer(root);
        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(dist == k){
                break;
            }
            for(int i = 0; i < size; i++){
                TreeNode node = q.poll();
                visited.put(node, true);
                if(node.left != null && !visited.containsKey(node.left)){
                    q.offer(node.left);
                }
                if(node.right != null && !visited.containsKey(node.right)){
                    q.offer(node.right);
                }
                if(parent.containsKey(node) && !visited.containsKey(parent.get(node))){
                    q.offer(parent.get(node));
                }
            }
            dist += 1;
        }
        while(!q.isEmpty()){
            ans.add(q.poll().val);
        }
        return ans;
    }
}
