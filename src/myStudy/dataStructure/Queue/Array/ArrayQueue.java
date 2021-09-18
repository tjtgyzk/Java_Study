package myStudy.dataStructure.Queue.Array;

public class ArrayQueue {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    //构造函数
    public ArrayQueue(int arrayMaxSize) {
        this.maxSize = arrayMaxSize;
        arr = new int[maxSize];
        this.front = -1;//指向头部
        this.rear = -1;//指向尾部
    }

    //是否满
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    //是否空
    public boolean isEmpty() {
        return rear == front;
    }

    //添加数据
    public void addQueue(int n) {
        //首先判断是否满
        if (isFull()) {
            System.out.println("队列已满，无法添加");
            return;
        }
        //添加数据
        rear++;
        arr[rear] = n;
    }

    //出队列
    public int getQueue() {
        //首先判断是否为空
        if (isEmpty()) {
            //必须返回值，所以抛出异常
            throw new RuntimeException("队列为空");
        }
        front++;
        return arr[front];
    }

    //输出队列
    public void showQueue() {
        //判断是否空
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = front + 1; i <= rear; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

    public int headQueue() {
        //判断是否空
        if (isEmpty()) {
            throw new RuntimeException("队列为空");//此处必须返回值，所以抛异常
        }
        return arr[front + 1];
    }

}
