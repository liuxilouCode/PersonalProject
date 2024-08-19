package BinarySearch;

/**
 * @Author Yi Liu
 * @Date 8/18/24
 * @SpecificTime 8:41 PM
 * 找比target小的最大值 sorted array
 */
public class LargestSmallerPositionOfTarget {
    public int largestSmaller(int[] nums, int target) { //no repeated value
        if (nums == null || nums.length == 0) return -1;
        int l = 0;
        int r = nums.length - 1;
        if (nums[l] == target) return -1;
        if (nums[r] == target) return r - 1;

        while (l + 1 < r) {
            int m = l + (r - l)/2;
            if (nums[m] == target) return m - 1;
            else if (nums[m] < target) l = m;
            else r = m;
        }

        if (nums[l] == target) return l - 1;
        if (nums[r] == target) return r - 1;
        return -1;
    }

    //if there's repeated value, utilize first position of target

    public int largestSmallerRepeated(int[] nums, int target) {
        FirstPositionOfTarget helper = new FirstPositionOfTarget();
        int res = helper.firstPosition(nums, target);
        if (res == -1 || res == 0) return -1;
        return res - 1;
    }
}
