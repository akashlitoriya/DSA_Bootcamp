package trees;
import binaryTree.BinaryTree;
import javafx.util.Pair;

import java.util.*;

public class BuildTreePreorder {
    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class BinaryTree{
        static int idx = -1;
        public Node buildTree(int nodes[]){
            idx++;
            if(nodes[idx] == -1){
                return null;
            }
            Node newNode = new Node(nodes[idx]);
            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);
            return newNode;
        }

    }
    public static void preorderTraversal(Node root){
        if(root == null){
            return;
        }
        System.out.print(root.data + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }
    public static void inorderTraversal(Node root){
        if(root == null){
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    public static void postorderTraversal(Node root){
        if(root == null){
            return;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.data + " ");
    }
    public static void levelOrderTraversal(Node root){
        if(root == null){
            return;
        }
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty()){
            Node currNode = q.remove();
            if(currNode == null){
                System.out.println();
                if(q.isEmpty()){
                    break;
                }else{
                    q.add(null);
                }
            }else{
                System.out.print(currNode.data + " ");
                if(currNode.left != null){
                    q.add(currNode.left);
                }
                if(currNode.right != null){
                    q.add(currNode.right);
                }
            }
        }
    }

    public static List<Integer> iterativePreorder(Node root){
        List<Integer> preorder = new ArrayList<>();
        if(root == null) return preorder;
        Stack<Node> st = new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            root = st.pop();
            preorder.add(root.data);
            if(root.right != null){
                st.push(root.right);
            }
            if(root.left != null){
                st.push(root.left);
            }
        }
        return preorder;
    }

    public static List<Integer> iterativeInorder(Node root){
        List<Integer> inorder = new ArrayList<>();
        Stack<Node> st = new Stack<>();
        Node node = root;
        while(true){
            if(node != null){
                st.push(node);
                node = node.left;
            }
            else{
                if(st.isEmpty()){
                    break;
                }
                node = st.pop();
                inorder.add(node.data);
                node = node.right;
            }
        }
        return inorder;
    }

    public static List<Integer> iterativePostOrderStack2(Node root){
        Stack<Node> st1 = new Stack<>();
        Stack<Node> st2 = new Stack<>();
        ArrayList<Integer> postorder = new ArrayList<>();
        if(root == null){
            return postorder;
        }
        st1.push(root);
        while(!st1.isEmpty()){
            root = st1.pop();
            st2.push(root);
            if(root.left != null) st1.push(root.left);
            if(root.right != null) st1.push(root.right);
        }
        while(!st2.isEmpty()){
            postorder.add(st2.pop().data);
        }
        return postorder;
    }
    public static List<Integer> iterativePostOrderStack1(Node root){
        Stack<Node> st = new Stack<>();
        ArrayList<Integer> post = new ArrayList<>();
        Node curr = root;
        while(curr != null || !st.isEmpty()){
            if(curr != null){
                st.push(curr);
                curr = curr.left;
            }
            else{
                Node temp = st.peek().right;
                if(temp == null){
                    temp = st.peek();
                    st.pop();
                    post.add(temp.data);
                    while(!st.isEmpty() && temp == st.peek().right){
                        temp = st.peek();
                        st.pop();
                        post.add(temp.data);
                    }
                }
                else{
                    curr = temp;
                }
            }
        }
        return post;
    }


    public static int countOfNode(Node root){
        if(root == null){
            return 0;
        }
        int leftNodes = countOfNode(root.left);
        int rightNodes = countOfNode(root.right);
        return leftNodes + rightNodes + 1;
    }
    public static int sumOfNode(Node root){
        if(root == null){
            return 0;
        }
        int sumLeft = sumOfNode(root.left);
        int sumRight = sumOfNode(root.right);
        return sumLeft + sumRight + root.data;
    }
    public static int height(Node root){
        if(root == null){
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int myHeight = Math.max(leftHeight, rightHeight) + 1;
        return myHeight;
    }

    //Diameter of tree using Approach - 1. Time Complexity = O(N^2)
    public static int findDiameter(Node root){
        if(root == null){
            return 0;
        }
        int diamLeft = findDiameter(root.left);
        int diamRight = findDiameter(root.right);
        int diamThrough = height(root.left) + height(root.right) + 1;

        return Math.max(diamLeft,Math.max(diamRight, diamThrough));
    }

//    Diameter of tree using Approach - 2. Time Complexity = O(N)
    static class TreeInfo{
        int ht;
        int diam;
        TreeInfo(int ht, int diam){
            this.ht = ht;
            this.diam = diam;
        }

    }
    public static TreeInfo getDiameter(Node root){
        if(root == null){
            return new TreeInfo(0,0);
        }
        TreeInfo left = getDiameter(root.left);
        TreeInfo right = getDiameter(root.right);
        int myHeight = Math.max(left.ht, right.ht) + 1;
        int diaLeft = left.diam;
        int diaRight = right.diam;
        int diaThrough = left.ht + right.ht + 1;

        int myDiam = Math.max(Math.max(diaLeft, diaRight), diaThrough);
        TreeInfo myInfo = new TreeInfo(myHeight, myDiam);
        return myInfo;
    }
    public static List<Integer> rightSideView(Node root) {
        List<Integer> ans = new ArrayList<Integer>();

        if(root == null){
            return ans;
        }
        Queue<Node> q = new LinkedList<Node>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            Node temp = q.peek();
            for(int i = 0; i < q.size(); i++){
                if(q.peek().left != null){
                    q.add(q.peek().left);
                }
                if(q.peek().right != null){
                    q.add(q.peek().right);
                }
                temp = q.peek();
                q.poll();
            }

            ans.add(temp.data);
        }
        return ans;
    }
    public static void main(String[] args) {
        int nodes[] = {1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1};
        BinaryTree tree = new BinaryTree();
        Node root = tree.buildTree(nodes);
        System.out.println(root.data);
        System.out.print("Preorder Traversal : ");
        preorderTraversal(root);
        System.out.println();
        System.out.print("Inorder Traversal : ");
        inorderTraversal(root);
        System.out.println();
        System.out.print("Postorder Traversal : ");
        postorderTraversal(root);
        System.out.println();
        System.out.println("Level Order :- ");
        levelOrderTraversal(root);
        System.out.println("Count of Nodes : " + countOfNode(root));
        System.out.println("Sum of Node : " + sumOfNode(root));
        System.out.println("Height of Tree : " + height(root));
        System.out.println("Diameter of Tree Approach - 1: " + findDiameter(root));
        System.out.println("Diameter of Tree Approach - 2: " + getDiameter(root).diam);

        System.out.println("Iterative Preorder : " + iterativePreorder(root));
        System.out.println("Iterative Inorder : " + iterativeInorder(root));
        System.out.println("Iterative Postorder using 2 stack : " + iterativePostOrderStack2(root));
        System.out.println("Iterative Postorder using 1 stack : " + iterativePostOrderStack1(root));
//        int nodes[] = {1,2,3,-1,5,-1,4};
//        BinaryTree tree = new BinaryTree();
//        Node root = tree.buildTree(nodes);
//        List<Integer> ans = rightSideView(root);
    }
}
