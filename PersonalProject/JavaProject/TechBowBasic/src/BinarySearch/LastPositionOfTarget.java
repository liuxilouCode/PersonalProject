package BinarySearch;

/**
 * @Author Yi Liu
 * @Date 8/18/24
 * @SpecificTime 7:27 PM
 *
 * sorted array with repeated value
 */
public class LastPositionOfTarget {
    public int lastPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0;
        int r = nums.length - 1;
        if (nums[r] == target) return r;

        while (l + 1 < r) {
            int m = l + (r - l)/2;
            if (nums[m] <= target) l = m;
            else r = m;
        }

        if (nums[l] == target) return l;
        if (nums[r] == target) return r;

        return -1;
    }
}
