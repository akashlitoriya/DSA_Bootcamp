package stackAndQueue;

public class CircularQueueArr<T> {
    private T data[];
    private int front;
    private int rear;
    private int size = 0;

    CircularQueueArr(T data[]){
        this.data = data;
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    public boolean isEmpty(){
        return size == 0? true: false;
    }

    public boolean isFull(){
        return size == this.data.length;
    }

    public void enque(T data){
        if(isFull()){
            System.out.println("Queue is Full");
            return ;
        }

        this.data[rear++] = data;
        rear = rear % this.data.length;
        size++;
    }

    public T deque(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return null;
        }
        T removed = this.data[front];
        front++;
        front = front % this.data.length;
        size--;
        return removed;
    }

    public void display(){
        int i = front;
        do{
            System.out.print(data[i] + " <-- ");
            i++;
        }
        while(i % this.data.length != rear);
        System.out.println("END");
    }

    public static void main(String[] args) {
        CircularQueueArr<Integer> queue = new CircularQueueArr<>(new Integer[5]);
        queue.enque(1);
        queue.enque(2);
        queue.enque(3);
        queue.enque(4);
        queue.enque(5);
        //queue.enque(6);

        queue.display();

        queue.deque();
        queue.display();
        queue.enque(6);
        queue.display();
    }
}
