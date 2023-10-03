package linkedList;

public class DoublyLinkedList {
    static class Node{
        int data;
        Node next;
        Node prev;
        Node(){
            data = -1;
            this.prev = null;
            this.next = null;
        }
        Node(int data){
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }
    private int size = 0;
    private Node head;
    private Node tail;
    DoublyLinkedList(){
        this.head = null;
        this.tail = null;
    }
    public void add(int val){
        if(head == null){
            Node newNode = new Node(val);
            head = newNode;
            tail = newNode;
            size++;
            return ;
        }
        Node newNode = new Node(val);
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
        size++;
    }
    public void add(int val, int idx){
        if(idx == 0){
            Node newNode = new Node(val);
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            if(tail == null) tail = newNode;
            size++;
            return ;
        }
        if(idx == size){
            Node newNode = new Node(val);
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
            size++;
            return ;
        }
        Node temp = head;
        int i = 0;
        while(i < idx - 1){
            temp = temp.next;
            i++;
        }
        Node newNode = new Node(val);
        newNode.next = temp.next;
        temp.next.prev = newNode;
        newNode.prev = temp;
        temp.next = newNode;
        size++;
    }
    public int remove(int idx){
        if(idx == 0){
            Node del = head;
            head = head.next;
            head.prev = null;
            del.next = null;
            size--;
            return del.data;
        }
        if(idx == size - 1){
            Node del = tail;
            tail = tail.prev;
            tail.next = null;
            del.prev = null;
            size--;
            return del.data;
        }
        int i = 0;
        Node temp = head;
        while(i < idx){
            temp = temp.next;
            i++;
        }
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
        size--;
        return temp.data;
    }
    public int size(){
        return size;
    }
    public void print(){
        System.out.print("HEAD -> ");
        int i = 0;
        Node temp = head;
        while(i < size){
            System.out.print(temp.data + " -> ");
            temp = temp.next;
            i++;
        }
        System.out.print("TAIL");
        System.out.println();
    }
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.print();
        list.add(10,3);
        list.print();
        list.remove(3);
        list.print();
    }
}
