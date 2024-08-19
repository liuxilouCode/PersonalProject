package BinarySearch;

/**
 * @Author Yi Liu
 * @Date 8/18/24
 * @SpecificTime 7:28 PM
 *
 * sorted array with repeated value
 */
public class LeetCode34_FindFirstAndLastPositions {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        if (nums == null || nums.length == 0) return res;

        res[0] = firstPosition(nums, target);
        res[1] = lastPosition(nums, target);

        return res;
    }

    private int firstPosition(int[] nums, int target) {
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

    private int lastPosition(int[] nums, int target) {
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
