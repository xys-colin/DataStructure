package cn.qmulin.search;

/**
 * 线性查找算法
 */
public class SeqSearch {
    public static void main(String[] args) {
        int arr[] ={1,9,11,-1,34,89};
        int index=seqSearch(arr,89);
        System.out.println(index);
    }
    public static int seqSearch(int[] array,int value){
        for (int i = 0; i < array.length; i++) {
            if (array[i]==value){
                return i;
            }
        }
        return -1;
    }
}
