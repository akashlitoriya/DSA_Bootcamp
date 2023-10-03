package binaryTreeQuestion;
import java.util.*;
public class AllRootToLeafPaths extends Tree{
    public List<List<Integer>> binaryTreePaths(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        getRootToNodePath(root, path, ans);

        return ans;
    }
    private void getRootToNodePath(TreeNode root, List<Integer> path, List<List<Integer>> allPaths){
        if(root == null){
            return;
        }
        path.add(root.val);
        if(isLeaf(root)){
            allPaths.add(path);
            return;
        }
        getRootToNodePath(root.left, path, allPaths);
        //if(root.left != null ) path.remove(path.size() - 1);
        getRootToNodePath(root.right, path, allPaths);
        //if(root.right != null) path.remove(path.size() - 1);
        path.remove(path.size() - 1);
    }
    private boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }

    public static void main(String[] args) {
        AllRootToLeafPaths obj = new AllRootToLeafPaths();
        Integer node[] = {1,2,3,null, 5};
        TreeNode head = obj.getTree(node);
        System.out.println(obj.binaryTreePaths(head));
    }
}
