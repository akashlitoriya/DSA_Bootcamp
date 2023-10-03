package stackAndQueue;

import java.util.LinkedList;

public class QueueLL<T> {
    private LinkedList<T> data;
    private int rear;

    QueueLL(){
        data = new LinkedList<>();
        rear = -1;
    }

    public void enque(T val){
        ++rear;
        data.add(rear,val);

    }
    public T deque(){
        if(rear == -1){
            System.out.println("Queue is empty");
        }
        T del = data.remove(0);
        return del;
    }
    public int size(){
        return rear + 1;
    }
    public boolean isEmpty(){
        return rear == -1;
    }
    public void print(){
        System.out.print("FRONT->");
        for(int i = 0; i < data.size(); i++){
            System.out.print(data.get(i) + "->");
        }
        System.out.print("REAR");
        System.out.println();
    }

    public static void main(String[] args) {
        QueueLL<Integer> q = new QueueLL<>();
        System.out.println(q.isEmpty());
        q.enque(1);
        q.enque(2);
        q.enque(3);
        q.print();
        System.out.println(q.deque());
        q.print();
        System.out.println(q.deque());
        q.print();
        System.out.println(q.deque());
        q.print();
    }
}
