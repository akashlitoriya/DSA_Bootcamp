package binaryTreeQuestion;


import java.util.*;

public class MaxWidth extends Tree{
    public static void main(String[] args) {

    }
    class Pair{
        TreeNode root;
        int num;
        Pair(TreeNode root, int num){
            this.root = root;
            this.num = num;
        }
    }
    private int getMaxWidth(TreeNode root){
        if(root == null) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));
        int ans = 0;
        while(!q.isEmpty()){
            int size = q.size();
            int min = q.peek().num;
            int first = 0, last = 0;
            for(int i = 0; i < size; i++){
                Pair pair = q.poll();
                TreeNode node = pair.root;
                int pIdx = pair.num - min;
                if(i == 0) first = pIdx;
                if(i == size - 1) last = pIdx;
                if(node.left != null) q.offer(new Pair(node.left, 2 * pIdx + 1));
                if(node.right != null) q.offer(new Pair(node.right, 2 * pIdx + 2));
            }
            ans = Math.max(ans, last - first + 1);
        }
        return ans;
    }
}
