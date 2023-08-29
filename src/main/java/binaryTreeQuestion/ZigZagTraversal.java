package binaryTreeQuestion;
import java.util.*;
public class ZigZagTraversal extends Tree{
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzag = new ArrayList<>();
        if(root == null){
            return zigzag;
        }
        Queue q = new LinkedList<TreeNode>();
        q.add(root);
        boolean leftToRight = true;
        while(!q.isEmpty()){
            int size = q.size();
            ArrayList<Integer> level = new ArrayList<>();
            for(int i = 0; i < size; i++){
                TreeNode node = (TreeNode)q.remove();
                int index = (leftToRight)? i: level.size() - i;
                level.add(index, node.val);
                if(node.left!= null) q.add(node.left);
                if(node.right != null) q.add(node.right);
            }
            leftToRight = !leftToRight;
            zigzag.add(level);
        }
        return zigzag;
    }

    public static void main(String[] args) {
        ZigZagTraversal obj = new ZigZagTraversal();
        Integer nodes[] = {3,9,20,null,null,15,7};
        TreeNode root = obj.getTree(nodes);
        System.out.println(obj.zigzagLevelOrder(root));
    }
}
