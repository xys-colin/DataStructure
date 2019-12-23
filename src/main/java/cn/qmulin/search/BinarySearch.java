package cn.qmulin.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找
 */
public class BinarySearch {
    public static void main(String[] args) {
        int array[] = {1, 8, 70, 89, 1000, 1234};
        int result=binarySearch(array,0,array.length-1,8);
    }

    /**
     * 查找一个目标值的下标
     * @param array
     * @param left
     * @param right
     * @param target
     * @return
     */
    public static int binarySearch(int[] array, int left, int right, int target) {
        int mid = (right - left) / 2 + left;
        if (left > right) {
            return -1;
        } else if (target == array[mid]) {
            return mid;
        }
        int midVal = array[mid];
        if (target > midVal) {
            return binarySearch(array, mid + 1, right, target);
        } else if (target < midVal) {
            return binarySearch(array, left, mid - 1, target);
        }
        return -1;
    }

    /**
     * 查找出所有目标值的下标
     * @param array
     * @param left
     * @param right
     * @param target
     * @return
     */
    public static List<Integer> binarySearc2(int[] array, int left, int right, int target) {
        if (left>right){
            return new ArrayList<>();
        }
        int mid = (right - left) / 2 + left;
        int midVal=array[mid];
        if (target>midVal){
            return binarySearc2(array,mid+1,right,target);
        }else if (target<midVal){
            return binarySearc2(array,left,mid-1,target);
        }else {
            List<Integer> resIndexList=new ArrayList<>();
            int temp=mid-1;
            while (temp >= 0 && array[temp] == target) {
                resIndexList.add(temp);
                temp--;
            }
            resIndexList.add(mid);
            temp=mid+1;
            while (temp <= array.length - 1 && array[temp] == target) {
                resIndexList.add(temp);
                temp++;
            }
            return resIndexList;
        }
    }
}
