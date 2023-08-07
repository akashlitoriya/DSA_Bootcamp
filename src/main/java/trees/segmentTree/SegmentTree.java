package trees.segmentTree;

public class SegmentTree {
    Node root;
    SegmentTree(int[] arr){
        this.root = constructTree(arr, 0, arr.length - 1);
    }

    static class Node{
        int data;
        int startInterval;
        int endInterval;
        Node left;
        Node right;

        Node(int startInterval, int endInterval){
            this.startInterval = startInterval;
            this.endInterval = endInterval;
        }

    }

    private Node constructTree(int[] arr, int start, int end){
        if(start == end){
            //Leaf Node
            Node leaf = new Node(start, start);
            leaf.data= arr[start];
            return leaf;
        }
        //Create newNode
        Node newNode = new Node(start, end);
        int mid = start + (end - start) / 2;
        newNode.left = constructTree(arr,start, mid);
        newNode.right = constructTree(arr, mid + 1, end);
        newNode.data = newNode.left.data + newNode.right.data;
        return newNode;
    }

    public int query(int qStart, int qEnd){
        return this.query(this.root, qStart, qEnd);
    }
    private int query(Node node, int qStart, int qEnd){
        if(node.startInterval >= qStart && node.endInterval <= qEnd){
            return node.data;
        }else if(node.startInterval > qEnd || node.endInterval < qStart){
            return 0;
        }else{
            return this.query(node.left, qStart, qEnd) + this.query(node.right, qStart,qEnd);
        }
    }

    public void update(int index, int value){
        int data = this.update(this.root, index, value);
    }
    private int update(Node node, int index, int value){
        if (index >= node.startInterval&& index <= node.endInterval){
            if(index == node.startInterval && index == node.endInterval) {
                node.data = value;
                return node.data;
            } else {
                int leftAns = update(node.left, index, value);
                int rightAns = update(node.right, index, value);
                node.data = leftAns + rightAns;
                return node.data;
            }
        }
        return node.data;
    }

    public void display() {
        display(this.root);
    }
    private void display(Node node) {
        String str = "";

        if(node.left != null) {
            str = str + "Interval=[" + node.left.startInterval + "-" + node.left.endInterval + "] and data: " + node.left.data + " => ";
        } else {
            str = str + "No left child";
        }

        // for current node
        str = str + "Interval=[" + node.startInterval + "-" + node.endInterval + "] and data: " + node.data + " <= ";

        if(node.right != null) {
            str = str + "Interval=[" + node.right.startInterval + "-" + node.right.endInterval + "] and data: " + node.right.data;
        } else {
            str = str + "No right child";
        }

        System.out.println(str + '\n');

        // call recursion
        if(node.left != null) {
            display(node.left);
        }

        if(node.right != null) {
            display(node.right);
        }
    }

}
