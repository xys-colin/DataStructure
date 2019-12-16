package cn.qmulin.queue;

public class CircleArrayDemo {
    public static void main(String[] args) {
        CircleArray array = new CircleArray(5);
    }
}

class CircleArray {
    private int maxSize;//表示数组的最大容量
    private int front;//指向队列的第一个元素
    private int rear;//队列尾，指向队列最后一个元素的后一个位置
    private int[] arr;//该数组用于存放数据,模拟队列

    CircleArray(int arrMaxSize) {
        maxSize = arrMaxSize;
        arr = new int[maxSize];
    }

    /**
     * 判断队列是否已满
     *
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public boolean isEmpty() {
        return rear == front;
    }

    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列已满,不能加入");
            return;
        }
        //直接将数据加入
        arr[rear] = n;
        //将rear后移,
        rear = (rear + 1) % maxSize;
    }

    /**
     * 获取对垒的数据,出队列
     *
     * @return
     */
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        int value = arr[front];
        front = (front + 1) % maxSize;
        return value;
    }

    /**
     * 显示队列的所有数据
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    public int size() {
        return (rear - front + maxSize) % maxSize;
    }

    public int headQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }
}
