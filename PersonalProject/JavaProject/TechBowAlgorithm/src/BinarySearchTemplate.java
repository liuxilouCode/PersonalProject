import java.lang.reflect.Array;
import java.util.Arrays;

public class BinarySearchTemplate {
    public static void main(String[] args) {
        int[] nums = {2,3,4,5,6,7,8,9,10};
        System.out.println(binarySearch(nums,3));

    }

    public static int binarySearch(int[] intArray, int target){
        //this template returns the index of my target in the sorted array
        if(intArray == null || intArray.length == 0){
            return -1;
        }
        int left = 0; //index number
        int right = intArray.length-1;
        while(left + 1 < right){
            //左右相邻的目的是把mid夹在中间 左右越过是直接找答案，需要另一种方法
            int mid = left + (right - left)/2; //middle index number
            //this condition guarantees that as long as left is less than right, the searching algorithm will keep running
            if(intArray[mid] < target){
                //if left index number is less than the wanted target, we cut off the left side
                left = mid;
            }
            else if(intArray[mid] > target){
                //if right index number is greater than the wanted target, we cut off the right side
                right  = mid;
            }
            else{
                return mid;
            }
        }
        //由于左右相邻是把mid夹在中间，这就到这 array[left]和array[right]本身没有被check过，需要post processing
        if(intArray[left] == target){
            return left;
        }
        if(intArray[right] == target){
            return right;
        }


        return -1;
        //这个方法方便找分界线  例如  0，1，2，3，4，5，6，7，8，9
        //假设我们找3.1，即3与4的分界线，那左右越过的方法就没有左右相邻方便
    }

    public static int binarySearchJump(int[] arrays, int target){
        if (arrays == null || arrays.length==0){
            return -1;
        }
        int left = 0;
        int right = arrays.length-1;
        while(left<=right){ //这个条件就是左右越过,不需要做post processing
            int mid = left + (right-left)/2;
            if (arrays[mid]>target){
                right = mid -1;
            }
            else if (arrays[mid]<target){
                left = mid +1;
            } else return mid;

        }
        return -1;
        //这个方便直接找target
    }
}




//最好的方法是 left+1 < right(left,right) 因为可以把分界线夹在中间