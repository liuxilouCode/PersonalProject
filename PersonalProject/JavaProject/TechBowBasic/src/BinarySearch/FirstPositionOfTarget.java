package BinarySearch;

/**
 * @Author Yi Liu
 * @Date 8/18/24
 * @SpecificTime 7:26 PM
 *
 * sorted array with repeated value
 */
public class FirstPositionOfTarget {
    public int firstPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0;
        int r = nums.length - 1;
        if (nums[l] == target) return l;

        while (l + 1 < r) {
            int m = l + (r - l)/2;
            if (nums[m] >= target) r = m;
            else l = m;
        }

        if (nums[l] == target) return l;
        if (nums[r] == target) return r;

        return -1;
    }
}
