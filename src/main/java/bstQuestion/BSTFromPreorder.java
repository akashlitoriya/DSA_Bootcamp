package bstQuestion;
//https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/description/
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
class TreeNode{
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val){
        this.val = val;
        this.left = null;
        this.right = null;
    }
}
public class BSTFromPreorder {
    /*
    Brute Force Approach
    T.C = O(N) + O(NLogN);
    S.C = 2O(N)
     */
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] inorder = Arrays.copyOfRange(preorder, 0, preorder.length);
        Arrays.sort(inorder);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return bstFromPreorderAndInorder(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, map);

    }
    private TreeNode bstFromPreorderAndInorder(int[] preorder,int pStart, int pEnd, int[] inorder, int iStart, int iEnd, Map<Integer, Integer> map){
        if(pStart > pEnd || iStart > iEnd){
            return null;
        }
        int idx = map.get(preorder[pStart]);
        int left = idx - iStart;
        TreeNode root = new TreeNode(preorder[pStart]);
        root.left = bstFromPreorderAndInorder(preorder, pStart + 1, pStart + left, inorder, iStart, idx - 1 , map);
        root.right = bstFromPreorderAndInorder(preorder, pStart + left + 1, pEnd, inorder, idx + 1, iEnd, map);
        return root;

    }

    public static void main(String[] args) {

    }
}
