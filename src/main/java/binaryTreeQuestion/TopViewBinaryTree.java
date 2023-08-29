package binaryTreeQuestion;
import java.util.*;
public class TopViewBinaryTree extends Tree{
    public static void main(String[] args) {
        TopViewBinaryTree obj = new TopViewBinaryTree();
        Integer nodes[] = {1,2,3,4,5,6,7};
        TreeNode root = obj.getTree(nodes);
        System.out.println(obj.getTopView(root));
    }
    class Pair{
        TreeNode node;
        int row;
        Pair(TreeNode node, int row){
            this.node = node;
            this.row = row;
        }
    }
    private List<Integer> getTopView(TreeNode root){
        List<Integer> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            Pair pair = q.remove();
            TreeNode node = pair.node;
            int x = pair.row;
            if(!map.containsKey(x)){
                map.put(x, node.val);
            }
            if(node.left != null){
                q.add(new Pair(node.left, x - 1));

            }
            if(node.right != null) q.add(new Pair(node.right, x + 1));
        }
        for(int val : map.values()){
            ans.add(val);
        }
        return ans;
    }
}
