package cn.qmulin.recursion;

public class Queen8 {
    int max=8;
    int[] array=new int[max];
    static int count=0;
    public static void main(String[] args) {
        Queen8 queen8=new Queen8();
        queen8.check(0);
        System.out.println("一共有多少种解法"+count);
    }

    /**
     * 放置第n个皇后
     * 注意:check是每一次递归时,进入check中都有for循环
     * @param n
     */
    private void check(int n){
        if (n>=max){
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            //先把当前这个皇后n,放到该行的第一列
            array[n]=i;
            //判断当放置第n个皇后到i列时,是否冲突
            if (judge(n)){
                check(n+1);
            }
            //如果冲突,就继续执行array[n]=i;即将第n个皇后,放置在本行得后移的一个位置
        }
    }
    /**
     * 查看当我们放置第n个皇后,就去检测该皇后是否和前面已放置的皇后冲突
     * @param n 表示第n个皇后
     * @return
     */
    private boolean judge(int n){
        for (int i = 0; i < n; i++) {
            if (array[i]==array[n]||Math.abs(n-i)==Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }
    /**
     * 将皇后摆放的位置输出
     */
    private void print(){
        count++;
        for (int value : array) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
