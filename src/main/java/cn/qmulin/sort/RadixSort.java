package cn.qmulin.sort;

import java.util.Arrays;

public class RadixSort {
    public static void main(String[] args) {
        int[] c = {24, 767, 834, 35, 17, 634, 912, 1340, 5, 4};
        radixSort(c);
        System.out.println(Arrays.toString(c));

    }

    public static void radixSort(int[] array) {
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (max < array[i]) {
                max = array[i];
            }
        }
        int maxLength = (max + "").length();
        //定义一个二维数组,表示10个桶
        int[][] bucket = new int[10][array.length];
        //为了记录每个桶中存放了多少个数据,定义一个一维数组来记录各个桶的每次放入的数据个数
        int[] bucketElementCounts = new int[10];
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {

            for (int j = 0; j < array.length; j++) {
                int digitOfElement = array[j] / n % 10;
                //放入到对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = array[j];
                bucketElementCounts[digitOfElement]++;
            }
            //按照这个桶的顺序(一维数组的下标依次取出数据,放入原来数组)
            int index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                if (bucketElementCounts[k] > 0) {
                    for (int j = 0; j < bucketElementCounts[k]; j++) {
                        array[index++] = bucket[k][j];
                    }
                }
                bucketElementCounts[k] = 0;
            }
        }
    }
}
