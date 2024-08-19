/**
 * @Author Yi Liu
 * @Date 7/21/22
 * @SpecificTime 4:41 PM
 */
public class LastPosition {
    public static int lastPosition(int[] arrays, int target){
        //corner case
        if (arrays == null || arrays.length == 0){ return -1;}
        int left = 0;
        int right = arrays.length-1;
        while (left + 1 < right){
            int mid = left + (right - left)/2;
            if (arrays[mid]<=target){
                left = mid;
                //防止左边界先返回target，我们要利用arrays[mid]<=target条件
                //因为我们要找的是last position
            }
            else right = mid;
        }
        //post processing for special cases such as arrays[arrays.length-1] = target
        //check right first because we want to find the last position
        if (arrays[right] == target) return right;
        if (arrays[left] == target) return left;
        return -1;
    }
}
