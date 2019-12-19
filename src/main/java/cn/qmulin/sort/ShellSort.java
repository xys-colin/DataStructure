package cn.qmulin.sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] array = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        shellSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void shellSort(int[] array) {
        int step;
        int len = array.length;
        for (step = len / 2; step > 0; step /= 2) {
            for (int i = step; i < len; i++) {
                int j = i;
                int temp = array[i];
                while (j-step >=0 && temp < array[j - step]) {
                    array[j]=array[j-step];
                    j-=step;
                }
                array[j]=temp;
            }
        }

    }
}
