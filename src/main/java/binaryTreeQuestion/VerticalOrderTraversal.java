package binaryTreeQuestion;
import java.util.*;
public class VerticalOrderTraversal extends Tree{


    public static void main(String[] args) {
        Integer nodes[] = {1,2,3,4,5,6,7};
        VerticalOrderTraversal obj = new VerticalOrderTraversal();
        TreeNode root = obj.getTree(nodes);
        System.out.println(obj.getVerticalOrder(root));
    }
    class Element{
        TreeNode node;
        int row;
        int col;
        Element(TreeNode node, int row, int col){
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }
    private List<List<Integer>> getVerticalOrder(TreeNode root){
        TreeMap<Integer,TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Element> q = new LinkedList<>();
        q.add(new Element(root,0,0));
        while(!q.isEmpty()){
            Element ele = q.remove();
            TreeNode node = ele.node;
            int row = ele.row;
            int col = ele.col;

            if(!map.containsKey(row)){
                map.put(row, new TreeMap<>());
            }
            if(!map.get(row).containsKey(col)){
                map.get(row).put(col,new PriorityQueue<>());
            }
            map.get(row).get(col).offer(node.val);
            if(node.left != null) q.add(new Element(node.left, row - 1, col + 1));
            if(node.right != null) q.add(new Element(node.right, row + 1, col + 1));
        }
        List<List<Integer>> ans = new ArrayList<>();
        for(TreeMap<Integer, PriorityQueue<Integer>> x: map.values()){
            ans.add(new ArrayList<>());
            for(PriorityQueue<Integer> y: x.values()){
                while(!y.isEmpty()){
                    ans.get(ans.size() - 1).add(y.poll());
                }
            }
        }
        return ans;
    }
}
