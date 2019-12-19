package cn.qmulin.sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int arr[] = {3, 9, -1, 10, 5};

        int[] array= bubbleSort(arr);
        //System.out.println(Arrays.toString(array));
    }
    public static int[] bubbleSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            int temp = 0;
            boolean flag=true;
            for (int j = 0; j < array.length-i; j++) {
                if (array[j] > array[j+1]) {
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                    flag=false;
                }
            }
            if (flag){
                break;
            }
            System.out.println(Arrays.toString(array));
        }
        return array;
    }
}
