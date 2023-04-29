package linkedListQuestion;

public class DesignLinkedList {
    static class MyLinkedList {
        Node head;
        int size;

        private class Node{
            int val;
            Node next;

            Node(){
                this.val = 0;
                this.next = null;
            }
            Node(int val){
                this.val = val;
                this.next = null;
            }
        }

        public MyLinkedList() {
            this.head = new Node();
            this.size = 0;
        }

        public int get(int index) {
            if(index >= size){
                return -1;
            }
            if(head.next == null){
                return -1;
            }
            Node temp = head.next;
            for(int i = 0; i < index ; i++){
                temp = temp.next;
            }
            return temp.val;
        }

        public void addAtHead(int val) {
            if(size == 0){
                Node newNode = new Node(val);
                head.next = newNode;
                size++;
                return;
            }
            Node newNode = new Node(val);
            newNode.next = head.next;
            head.next = newNode;
            size++;

        }

        public void addAtTail(int val) {
            Node temp = head.next;
            while(temp.next != null){
                temp = temp.next;
            }
            Node newNode = new Node(val);
            temp.next = newNode;
            size++;
        }

        public void addAtIndex(int index, int val) {
            if(index == 0){
                addAtHead(val);
                return;
            }
            if(index == size){
                addAtTail(val);
                return;
            }
            Node temp = head.next;
            for(int i = 0; i < index - 1; i++){
                temp = temp.next;
            }
            Node newNode = new Node(val);
            newNode.next = temp.next;
            temp.next = newNode;
            size++;

        }

        public void deleteAtIndex(int index) {
            if(index == 0){
                head.next = head.next.next;
                return;
            }
            if(index >= size){
                return;
            }
            Node temp = head.next;
            for(int i = 0; i < index - 1; i++){
                temp = temp.next;
            }
            temp.next = temp.next.next;
            size--;
        }
        private void print(){
            Node temp = head.next;
            while(temp != null){
                System.out.print(temp.val + "-->");
                temp = temp.next;
            }
            System.out.print("END");
            System.out.println();
        }

    }

    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addAtHead(1);
        list.print();
        list.addAtTail(3);
        list.print();
        list.addAtIndex(1,2);
        list.print();
        System.out.println(list.get(1));
        list.deleteAtIndex(1);
        list.print();
        System.out.println(list.get(1));
        System.out.println(list.get(3));
        list.deleteAtIndex(3);
        list.deleteAtIndex(0);
        System.out.println(list.get(0));
        list.deleteAtIndex(0);
        System.out.println(list.get(0));
    }

}
