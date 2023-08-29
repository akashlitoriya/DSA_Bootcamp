package binaryTreeQuestion;
import java.util.*;
public class BottomViewBinaryTree extends Tree{
    public static void main(String[] args) {

    }
    class Pair{
        TreeNode node;
        int row;
        Pair(TreeNode node, int row){
            this.node = node;
            this.row = row;
        }
    }
    private List<Integer> getBottomView(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root, 0));
        while(!q.isEmpty()){
            Pair pair = q.remove();
            TreeNode node = pair.node;
            int x = pair.row;
            map.put(x, node.val);
            if(node.left != null) q.add(new Pair(node.left, x - 1));
            if(node.right != null) q.add(new Pair(node.right, x + 1));
        }

        for(int val : map.values()){
            ans.add(val);
        }
        return ans;
    }
}
