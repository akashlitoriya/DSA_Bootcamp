package linkedList;

public class SingleLinkedList {
    public static class SingleLL<T>{
        Node head;
        int size = 0;

        SingleLL(){
            head = new Node();

        }
        private class Node{
            Node next;
            T data;
            Node(){
                this.next = null;
                this.data = null;
            }
            Node(T data){
                this.next = null;
                this.data = data;
            }
        }

        public void insertFront(T data){
            Node node = new Node(data);
            node.next = head.next;
            head.next = node;
            size++;
        }

        public void insertEnd(T data){
            if(head.next == null){
                insertFront(data);
                return;
            }
            Node node = new Node(data);
            Node temp = head.next;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = node;
            size++;
        }
        public void insertAt(int index, T data){
            if(index == 0){
                insertFront(data);
                return;
            }
            if(index == size){
                insertEnd(data);
                return;
            }
            Node node = new Node(data);
            Node temp = head.next;
            for(int i = 1; i < index; i++){
                temp = temp.next;
            }
            node.next = temp.next;
            temp.next = node;
            size++;
        }

        public T deleteFront(){
            Node node = head.next;
            head.next = node.next;
            node.next = null;
            size--;
            return node.data;
        }

        public T deleteEnd(){
            Node temp = head.next;
            while(temp.next.next != null){
                temp = temp.next;
            }
            Node node = temp.next;
            temp.next = null;
            size--;
            return node.data;
        }

        public T delete(T data){
            Node temp = head.next;
            Node prev = head.next;
            while(temp.next.data != data){
                temp = temp.next;
                prev = prev.next;

            }
            prev.next = temp.next.next;
            size--;
            return temp.next.data;
        }

        public void reverse(){
            if(head.next.next == null){
                return;
            }
            Node prev = null;
            Node curr = head.next;
            Node next = curr.next;
            while(curr != null){
                curr.next = prev;
                prev = curr;
                curr = next;
                if(next != null){
                    next = next.next;
                }
            }
            head.next = prev;
        }

        public void printList(){
            System.out.print("HEAD --> ");
            Node node = head.next;
            while(node != null){
                System.out.print(node.data + " --> ");
                node = node.next;
            }
            System.out.print("END");
            System.out.println();
        }

        public static void main(String[] args) {
            SingleLL<Integer> list = new SingleLL<>();
            list.insertFront(5);
            list.insertFront(6);
            list.insertFront(3);
            list.printList();
            list.insertEnd(10);
            list.printList();
            list.insertAt(0,99);
            list.printList();
            list.insertAt(5, 100);
            list.printList();
            list.deleteFront();
            list.printList();
            list.deleteEnd();
            list.printList();
            list.delete(5);
            list.printList();
            list.reverse();
            list.printList();
        }
    }
}
