package myStudy.dataStructure.Queue.Array;

public class Demo {
    public static void main(String[] args) {
        CircleArray queue = new CircleArray(5);
        queue.addQueue(10);
        queue.addQueue(2);
        System.out.println(queue.headQueue());
        queue.showQueue();
        System.out.println(queue.getQueue());
        queue.showQueue();
        queue.addQueue(5);
        queue.addQueue(3);
        queue.addQueue(6);
        queue.showQueue();
        queue.getQueue();
        queue.addQueue(9);
        System.out.println(queue.isFull());
        System.out.println(queue.headQueue());
        queue.showQueue();
    }
}
