package cn.qmulin.stack;

public class ArrayStackDemo {
    public static void main(String[] args) {

    }
}

class ArrayStack {
    private int maxSize;//栈的大小
    private int[] stack;
    private int top = -1;//top表示栈顶,初始化为-1

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public boolean isFull(){
        return top==maxSize-1;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public void push(int value){
        if (isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top]=value;
    }
    public int pop(){
        if (isEmpty()){
            throw new RuntimeException("栈空,没有数据");
        }
        int value=stack[top];
        top--;
        return value;
    }
    public void list(){
        if (isEmpty()){
            throw new RuntimeException("栈空,没有数据");
        }
        for (int i = top; i >=0 ; i--) {
            System.out.println("stack[]="+stack[top]);
        }
    }
}
