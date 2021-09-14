package myStudy.dataStructure.Queue.Array;

public class CircleArray {
    private int maxSize;
    private int front;
    private int rear;
    private int[] arr;

    public CircleArray(int arrMaxSize) {
        this.maxSize = arrMaxSize;
        arr = new int[maxSize];
        this.front = 0;
        this.rear = 0;
    }

    //是否满
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    //是否空
    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        //首先判断是否满
        if (isFull()) {
            System.out.println("队列已满，无法添加");
            return;
        }
        //添加数据
        arr[rear] = n;
        //重点
        rear = (rear + 1) % maxSize;
    }

    //出队列
    public int getQueue() {
        //首先判断是否为空
        if (isEmpty()) {
            //必须返回值，所以抛出异常
            throw new RuntimeException("队列为空");
        }
        //下列代码不行，return之后函数就不再执行下去了
        //return arr[front];
        int data = arr[front];
        front = (front + 1) % maxSize;
        return data;
    }

    //输出数据
    //有效数据数量(rear+maxSize-front)%maxSize
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }

    public void showQueue() {
        //判断是否空
        if (isEmpty()) {
            System.out.println("队列为空");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.print(arr[i % maxSize] + " ");//注意数组下标为i%maxSize
        }
        System.out.println("");
    }
    public int headQueue() {
        //判断是否空
        if (isEmpty()) {
            throw new RuntimeException("队列为空");//此处必须返回值，所以抛异常
        }
        return arr[front];
    }

}
