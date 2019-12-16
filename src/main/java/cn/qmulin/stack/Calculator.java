package cn.qmulin.stack;

public class Calculator {
    public static void main(String[] args) {
        String expression = "5-3*2+1";
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operaStack = new ArrayStack2(10);
        int index = 0, num1 = 0, num2 = 0, oper = 0, res = 0;
        char[] ch;//将每次扫描得到char保存到ch
        String keepNum = "";
        ch = expression.toCharArray();
        for (int i = 0; i < ch.length; i++) {
            if (operaStack.isOperation(ch[i])) {
                if (!operaStack.isEmpty()) {
                    if (operaStack.priority(ch[i]) <= operaStack.priority(operaStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operaStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        numStack.push(res);
                        operaStack.push(ch[i]);
                    } else {
                        operaStack.push(ch[i]);
                    }
                } else {
                    operaStack.push(ch[i]);
                }
            } else {//如果是数,则直接入数栈
                keepNum += ch[i];
                if (i == ch.length - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    if (operaStack.isOperation(ch[i + 1])) {
                        numStack.push(Integer.parseInt(keepNum));
                        keepNum = "";
                    }
                }
            }
        }
        while (!operaStack.isEmpty()) {
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operaStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        System.out.println(res);

    }
}

class ArrayStack2 {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public int peek() {
        return stack[top];
    }

    public boolean isFull() {
        return top == maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int value) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("栈空,没有数据");
        }
        int value = stack[top];
        top--;
        return value;
    }

    /**
     * 运算符的优先级
     *
     * @param operation 运算符
     * @return 优先级的等级
     */
    public int priority(int operation) {
        if (operation == '*' || operation == '/') {
            return 1;
        } else if (operation == '+' || operation == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    public boolean isOperation(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    public int cal(int num1, int num2, int operation) {
        int res = 0;
        switch (operation) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }
}