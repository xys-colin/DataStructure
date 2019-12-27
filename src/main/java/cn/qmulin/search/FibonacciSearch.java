package cn.qmulin.search;

import java.util.Arrays;

public class FibonacciSearch {
    static int maxSize;

    public static void main(String[] args) {
        int[] array = {1, 8, 10, 89, 100, 124};
        maxSize = array.length;
        System.out.println(fibSearch(array,89));
    }

    public static int[] fibonacci() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }

    public static int fibSearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        int k = 0;//表示斐波那契分割数值的下标
        int mid;
        int f[] = fibonacci();//获取到斐波那契数列
        while (high > f[k] - 1) {
            k++;
        }
        //因为f[k]可能大于array的长度,因此我们需要构造一个新的数组,并指向temp[]
        int[] temp = Arrays.copyOf(array, f[k]);
        //实际上需求使用a数组最后的数填充temp
        for (int i = high + 1; i < temp.length; i++) {
            temp[i] = array[high];
        }
        while (low<=high){
            mid=low+f[k-1]-1;
            if (key<temp[mid]){
                high=mid-1;
                k--;
            }else if (key>temp[mid]){
                low=mid+1;
                k-=2;
            }else {
                if (mid<=high){
                    return mid;
                }else {
                   return high;
                }
            }
        }
        return -1;
    }
}
