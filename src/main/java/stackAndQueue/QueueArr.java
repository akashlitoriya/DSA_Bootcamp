package stackAndQueue;

public class QueueArr <T>{
    private T data[];
    private int front;
    private int rear;

    QueueArr(T data[]){
        this.data = data;
        this.front = 0;
        this.rear = 0;
    }

    public void enque(T data){
        if(rear >= this.data.length){
            System.out.println("Queue is full");
            return ;
        }
        this.data[rear] = data;
        rear++;
    }
    public T deque(){
        if(front > rear){
            System.out.println("Queue is empty");
            return null;
        }
        T removed  = data[front];
        //shift the items to left
        for(int i = 1 ; i < rear; i++){
            data[i-1] = data[i];
        }
        rear--;
        return removed;
    }

    public T front(){
        if(front > rear){
            System.out.println("Queue is empty");
            return null;
        }
        return data[front];
    }

    public void display(){
        for(int i = front; i < rear; i++){
            System.out.print(data[i] + " <-- ");
        }
        System.out.println("END");

    }

    public static void main(String[] args) {
        QueueArr<Integer> queue = new QueueArr<>(new Integer[5]);
        queue.enque(1);
        queue.enque(2);
        queue.enque(3);
        queue.enque(4);
        queue.enque(5);
        //queue.enque(6);

        queue.display();
    }

}
