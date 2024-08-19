package Sorting;

/**
 * @Author Yi Liu
 * @Date 7/25/22
 * @SpecificTime 7:48 PM
 * 这是quick sort的一道变型题
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * 这道题实际上是考察能否用stable的方法去quick sort一个array
 * 我们简化这道题为 nums = {1,1,1,1,1,0,0,0,0,0}
 */
public class QuickSort {

    public static int[] sortBinary(int[] nums){
        if (nums == null || nums.length <= 1){
            return nums;
        }
        int left = 0;
        int right = nums.length-1;
        while(left<right){
            /**
            while(nums[left]==1){
                left++;
            } 不能用while loop，edge case会进入死循环 例如{1,1,1,1,1,1,1,} 或 {0,0,0,0,0,0,0}
            while(nums[right]==0){
                right--;
            }
             if else可以解决这个问题是因为，for loop和while loop的嵌套导致外层loop的条件在内层没走完的情况下是无法判定的
             而if else因为只走一遍，外层while loop每次跑一遍都要check以下条件
             */
            if (nums[left] == 1){
                left++;
            }
            else if (nums[right] == 0){
                right--;
            }

            //otherwise, we swap it because if means nums[left] = 0 yet nums[right] = 1
            else {
                swap(nums,left,right);
            }
        }
        return nums;

    }

    private static void swap(int[] nums, int left, int right){
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
