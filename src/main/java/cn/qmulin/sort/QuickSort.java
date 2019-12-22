package cn.qmulin.sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] array = {9, 9, 8, 7, 6, 8, 5, 4, 3, 1, 0, 2};
        quickSort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
    }

    public static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        } else {
            int i = left;
            int j = right + 1;
            int pivot = array[left];// pivot 为选取的基准元素（头元素）
            while (true) {
                while (i < right && array[++i] < pivot) {
                }

                while (j > 0 && array[--j] > pivot) {
                }

                if (i >= j) {// 左右游标相遇时候停止， 所以跳出外部while循环
                    break;
                } else {
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;// 左右游标未相遇时停止, 交换各自所指元素，循环继续
                }
            }
            int temp = array[left];
            array[left] = array[j];
            array[j] = temp;//基准元素和游标相遇时所指元素交换，为最后一次交换
            quickSort(array, left, j - 1);
            quickSort(array, j + 1, right);
        }
    }
}
