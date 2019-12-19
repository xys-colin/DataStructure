package cn.qmulin.sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] array={9,98,45,25,9,8,2};
        selectSort(array);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 选择排序
     * @param array
     */
    public static void selectSort(int[] array){
        for (int i = 0; i < array.length-1; i++) {
            int min=i;
            for (int j = i+1; j < array.length; j++) {
                if (array[j]<array[min]){
                       min=j;
                }
            }
            if (min!=i){
                int temp=array[i];
                array[i]=array[min];
                array[min]=temp;
            }
        }
    }
}
