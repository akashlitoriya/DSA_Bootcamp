package binaryTreeQuestion;
import java.util.*;
public class RootToNodePath extends Tree{
    public static void main(String[] args) {
        RootToNodePath obj = new RootToNodePath();
        Integer nodes[] = {1,2,3,4,5,null, null, null, null,6,7};
        TreeNode root = obj.getTree(nodes);
        TreeNode target = new TreeNode(7);
        System.out.println(obj.getRootToNode(root, target));
        System.out.println(obj.getPath(root,target.val));
    }

    private List<Integer> getPath(TreeNode root, int x){
        ArrayList<Integer> path = new ArrayList<>();
        if(root == null) return path;
        boolean check = getPathHelper(root, path, x);
        return path;
    }
    private boolean getPathHelper(TreeNode root, ArrayList<Integer> path, int x){
        if(root == null) return false;
        if(root.val == x){
            path.add(root.val);
            return true;
        }
        path.add(root.val);
        if(getPathHelper(root.left, path, x) || getPathHelper(root.right, path, x)){
            return true;
        }
        path.remove(path.size() - 1);
        return false;
    }
    private List<Integer> getRootToNode(TreeNode root, TreeNode target){
        List<Integer> path = new ArrayList<>();

        Stack<TreeNode> st = new Stack<>();
        st.push(root);
        path.add(root.val);
        while(!st.isEmpty()){
            if(st.peek().val == target.val){
                break;
            }
            TreeNode curr = st.peek();
            if(curr.left != null){
                st.push(curr.left);
                path.add(curr.left.val);
            }else{
                if(curr.right != null){
                    st.push(curr.right);
                    path.add(curr.right.val);
                }else{
                    st.pop();
                    TreeNode node = st.pop();
                    path.remove(path.size() - 1);
                    if(node.right != null){
                        path.add(node.right.val);
                        st.push(node.right);
                    }

                }
            }
        }

        return path;
    }
}
