package Sorting;

/**
 * @Author Yi Liu
 * @Date 7/24/22
 * @SpecificTime 9:11 PM
 * Merge Sort是一个稳定排序办法，即排序时不需要对原数组进行改变，通过helper数组改变，发生错误也不会影响原来的数据
 * 时间复杂度 O(nlog n) + O(n) = O(nlog n)
 * 空间复杂度 log n + O(nlog n) === O(n)
 * 先局部有序，再全局有序
 */
public class MergeSort {
    public void mergeSort(int[] arrays, int left, int right, int[] helper){
        //helper should have the same size of the to-be-sorted array
        if (arrays == null || arrays.length == 0){
            return;
        }

        else if (left < right){
            int mid = left + (right - left)/2;
            mergeSort(arrays,left,mid,helper); //sort left
            mergeSort(arrays,mid+1,right,helper); //sort right
            sum(arrays,left,right,mid,helper); //merge sorted sub-arrays to an array
        }
    }

    public void sum(int[] arrays, int left, int right, int mid, int[] helper){
        //this is the difficult part
        int i = left; //initial index for the first half of the divided array
        int j = mid + 1; //initial index for the second half of the divided array
        int pointer = 0; //index for helper array
        while (i<=mid && j<=right){ //right is the end index of the array
            if (arrays[i]<=arrays[j]){
                helper[pointer] = arrays[i];
                pointer++;
                i++;

            } else {
                helper[pointer] = arrays[j];
                pointer++;
                j++;
            }
        }

        while(i<=mid){
            helper[pointer] = arrays[i];
            pointer++;
            i++;
        }

        while(j<=right){
            helper[pointer] = helper[j];
            pointer++;
            j++;
        }
        //merge
        int tempIndex = left;
        int k = 0;
        while(tempIndex <= right){
            arrays[tempIndex] = helper[k];
            k++;
            tempIndex++;
        }
    }
}
