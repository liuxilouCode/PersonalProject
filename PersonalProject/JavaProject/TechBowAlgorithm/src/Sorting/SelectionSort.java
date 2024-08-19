package Sorting;

import java.util.Arrays;

/**
 * @Author Yi Liu
 * @Date 7/24/22
 * @SpecificTime 7:58 PM
 */
public class SelectionSort {
    public static int[] selectionSort(int[] arrays) {
        if (arrays == null || arrays.length <= 1) {
            return arrays;
            //这个corner case要非常注意，sorting的时候并不是arrays.length == 0
            //因为一个元素的array也不需要排序
        }
        for (int i = 0; i < arrays.length; i++) {
            for (int j = arrays.length - 1; j > i; j--) {
                if (arrays[j] < arrays[i]) {
                    swap(arrays, i, j);
                }
            }
            /**我采取的是双指针逆向而行，老刘用的是双指针同向而行，说实话我不是太理解同向而行背后的逻辑
             * 以下是同向而行的代码
             *
             *         int minIndex = 0;
             *         for (int i = 0; i < arrays.length-1; i++){
             *             for (int j = i+1; j < arrays.length; j++){
             *                 if (arrays[j] < arrays[minIndex]){
             *                     minIndex = j;
             *                 }
             *                 swap(arrays, i, minIndex);
             *             }
             *             return arrays;
             *         }
             */
        }
        return arrays;
        //java 是pass by value （pass by referenced variable copy），如果我们是void，也可以访问最终sort好的array
        //如果return的是arrays，那其实return的是arrays' 即stack中的copy，这个copy访问的是同一个地址
        //如果return的是void，那再调用的时候是arrays本身
    }

    private static void swap(int[] arrays,int i, int j){
        int temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }

    public static void main(String[] args) {
        int[] array = {3,8,9,10,2,4};
        System.out.println(Arrays.toString(selectionSort(array)));


    }
}
