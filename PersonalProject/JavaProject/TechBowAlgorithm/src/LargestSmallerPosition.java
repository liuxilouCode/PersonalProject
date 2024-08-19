/**
 * @Author Yi Liu
 * @Date 7/21/22
 * @SpecificTime 8:23 PM
 */
public class LargestSmallerPosition {
    public static void main(String[] args) {
        int[] array = {2,3,4,5,6,8,9,10};
        int result = largestSmaller(array,7);
        System.out.println(result);
    }

    /** 我自己的思路是按照closest position来找，但我忽略了一个问题。如果有数个重复数字，那我的方法就会不能正常返回想找的值
     * 而且一旦值不在数组中，也会返回错误的值
    public static int largestSmallerPosition(int[] arrays, int target){
        int left = 0;
        if (arrays == null || arrays.length == 0 || arrays[left] == target){return -1;}
        int right = arrays.length-1;
        while (left + 1 < right){
            int mid = left + (right-left)/2;
            if (arrays[mid]<target){
                left = mid;
            }
            else if (arrays[mid]>right){
                right = mid;
            } else return mid-1;
        }
        if (arrays[right] == target){return right-1;}
        else if (arrays[right] < target){return right;}
        else return -1;
    }

     答案如下
     */
    public static int largestSmaller(int[] arrays, int target){
        if (arrays == null|| arrays.length ==0){return -1;}
        if (arrays[arrays.length-1] < target){return arrays.length-1;}
        int left = 0;
        int right = arrays.length-1;
        while (left+1 < right){
            int mid = left +(right-left)/2;
            if (arrays[mid] < target){
                left = mid;
            } else right = mid;
        } //这段仍然是利用binarySearch找边界
        if (arrays[left] == target){
            if (left == 0){return 0;}
            else return left - 1;
        } else return left;
    }
}
