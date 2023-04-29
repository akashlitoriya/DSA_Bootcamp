package trees;

import java.util.ArrayList;

public class BinarySearchTree {

    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
        }
    }
    public static Node insert(Node root, int val){
        if(root == null){
            root = new Node(val);
            return root;
        }
        if(root.data > val){
            //left subtree
            root.left = insert(root.left, val);
        }else{
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inorderTraversal(Node root){
        if(root == null){
            return ;

        }
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    public static boolean searchBST(Node root, int key){
        if(root == null){
            return false;
        }
        if(root.data == key){
            return true;
        }
        else if(root.data < key){
            return searchBST(root.right, key);
        }else{
            return searchBST(root.left, key);
        }
    }

    public static Node delete(Node root, int val){
        if(root.data > val){
            root.left = delete(root.left, val);
        }
        else if(root.data < val){
            root.right = delete(root.right, val);
        }else{
            //root.data == val
            //case 1;
            if(root.left == null && root.right == null){
                return null;
            }
            //case 2:
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            //Case 3:
            Node IS = inorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static Node inorderSuccessor(Node root){
        while(root.left != null){
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int x, int y){
        if(root == null){
            return;
        }
        if(root.data >= x && root.data <= y){
            printInRange(root.left, x, y);
            System.out.print(root.data + " ");
            printInRange(root.right, x, y);
        }
        else if(root.data >= y){
            printInRange(root.left, x, y);
        }else{
            printInRange(root.right, x, y);
        }
    }

    public static void printRoot2Leaf(Node root, ArrayList<Integer> path){
        if(root == null){
            return;
        }
        path.add(root.data);
        //leaf
        if(root.left == null && root.right == null){
            printpath(path);
        }else{
            printRoot2Leaf(root.left, path);
            printRoot2Leaf(root.right, path);
        }
        path.remove(path.size() - 1);
    }
    public static void printpath(ArrayList<Integer> path){
        for(int i = 0; i < path.size(); i++){
            System.out.print(path.get(i) + "-->");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int values[] = {5,1,3,4,2,7};
        Node root = null;
        for(int i = 0; i < values.length; i++){
            root = insert(root, values[i]);
        }
        inorderTraversal(root);
        System.out.println();
        System.out.println("Search key = 5 : " + searchBST(root, 5));
        System.out.println("Search key = 6 : " + searchBST(root, 6));

        int val[] = {8,5,10,3,6,11,1,4,14};
        Node newRoot = null;
        for(int i = 0; i < val.length; i++){
            newRoot = insert(newRoot, val[i]);
        }
        System.out.println("Inorder newRoot : ");
        inorderTraversal(newRoot);
        System.out.println();


//        System.out.println("Delete Node with no child : " );
//        delete(newRoot, 4);
//        inorderTraversal(newRoot);
//        System.out.println();
//
//        System.out.println("Delete Node with one child : ");
//        delete(newRoot, 10);
//        inorderTraversal(newRoot);
//        System.out.println();
//
//        System.out.println("Delete Node with two child : ");
//        delete(newRoot, 5);
//        inorderTraversal(newRoot);
//        System.out.println();

        System.out.println("Print nodes in range 6 - 10 : ");
        printInRange(newRoot,6, 10);
        System.out.println();
        printRoot2Leaf(newRoot, new ArrayList<>());

    }
}
