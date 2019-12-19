package cn.qmulin.sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] array={4,2,8,9,5,7,6,1,3};
        insertSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void insertSort(int[] array){
        for (int i = 1; i < array.length; i++) {
            //记录要插入的数
            int temp=array[i];
            while (i>0&&temp<array[i-1]){
                array[i]=array[i-1];
                i--;
            }
            array[i]=temp;
        }
    }
}
