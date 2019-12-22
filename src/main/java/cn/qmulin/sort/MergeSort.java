package cn.qmulin.sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] c = {2,7,8,3,1,6,9,0,5,4};
        c = mergeSort(c,0,c.length-1);
        System.out.println(Arrays.toString(c));
    }

    public static int[] mergeSort(int[] c, int start, int last) {
        if (last > start) {
            //也可以是(start+last)/2，这样写是为了防止数组长度很大造成两者相加超过int范围，导致溢出
            int mid = start + (last - start) / 2;
            mergeSort(c, start, mid);//左边数组排序
            mergeSort(c, mid + 1, last);//右边数组排序
            merge(c, start, mid, last);//合并左右数组
        }
        return c;
    }

    /**
     * 合并
     *
     * @param array 排序的原始数组
     * @param start  左边有序序列的初始索引
     * @param mid   中间索引
     * @param last 右边索引
     */
    public static void merge(int[] array, int start, int mid, int last) {
        int[] temp = new int[last - start+1];//定义临时数组
        int i = start;//初始化i,左边有序列的初始索引
        int j = mid + 1;//初始化i,右边有序列的初始索引
        int t = 0;//指向temp数组的当前索引
        while (i <= mid && j <= last) {
            if (array[i] <= array[j]) {
                temp[t++] = array[i++];

            } else {
                temp[t++] = array[j++];

            }
        }
        while (i <= mid) {
            temp[t++] = array[i++];
        }
        while (j <= last) {
            temp[t++] = array[j++];
        }
        //把新数组中的数覆盖到c数组中
        for (int k2 = 0; k2 < temp.length; k2++) {
            array[k2 + start] = temp[k2];
        }
    }
}
