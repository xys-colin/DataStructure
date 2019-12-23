package cn.qmulin.search;


public class InsertSearch {
    public static void main(String[] args) {
        int[] array = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        int result = insertValueSearch(array, 0, array.length - 1, 3);
        System.out.println(result);
    }

    public static int insertValueSearch(int[] array, int left, int right, int target) {
        if (left > right || target < array[0] || target > array[array.length - 1]) {
            return -1;
        }
        int mid = left + (right - left) * (target - array[left]) / (array[right] - array[left]);
        int midVal = array[mid];
        if (target < midVal) {
            return insertValueSearch(array, left, mid - 1, target);
        } else if (target > midVal) {
            return insertValueSearch(array, mid + 1, right, target);
        } else {
            return mid;
        }
    }
}
