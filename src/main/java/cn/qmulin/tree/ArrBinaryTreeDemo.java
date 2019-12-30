package cn.qmulin.tree;

public class ArrBinaryTreeDemo {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(array);
        arrBinaryTree.infixOrder(0);
    }
}

/**
 * 编写一个实现顺序存储二叉树遍历
 */
class ArrBinaryTree {
    private int[] array;

    public ArrBinaryTree(int[] array) {
        this.array = array;
    }

    public void preOrder(int index) {
        //如果数组为空,或者array.length=0;
        if (array == null || array.length == 0) {
            System.out.println("数组为空,不能按照二叉树的前序遍历");
        }
        System.out.println(array[index]);
        if ((index * 2 + 1) < array.length) {
            preOrder(2 * index + 1);
        }
        if ((index * 2 + 2) < array.length) {
            preOrder(2 * index + 2);
        }
    }

    public void infixOrder(int index) {
        //如果数组为空,或者array.length=0;
        if (array == null || array.length == 0) {
            System.out.println("数组为空,不能按照二叉树的前序遍历");
        }
        if ((index * 2 + 1) < array.length) {
            infixOrder(2 * index + 1);
        }
        System.out.println(array[index]);

        if ((index * 2 + 2) < array.length) {
            infixOrder(2 * index + 2);
        }
    }
}
