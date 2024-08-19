package BinarySearch;

/**
 * @Author Yi Liu
 * @Date 8/18/24
 * @SpecificTime 8:49 PM
 * 比target大的最小值 sorted array
 */
public class SmallestLargerPositionOfTarget {
    public int smallestLarger(int[] nums, int target) { //no repeated value
        if (nums == null || nums.length == 0) return -1;
        int l = 0;
        int r = nums.length - 1;
        if (nums[l] == target) return 1;
        if (nums[r] == target) return -1;

        while (l + 1 < r) {
            int m = l + (r - l)/2;
            if (nums[m] == target) return m + 1;
            else if (nums[m] < target) l = m;
            else r = m;
        }

        if (nums[l] == target) return l + 1;
        if (nums[r] == target) return r + 1;

        return -1;
    }

    //if there's repeated value, utilize last position of target

    public int smallestLargerRepeated(int[] nums, int target) {
        LastPositionOfTarget helper = new LastPositionOfTarget();
        int res = helper.lastPosition(nums, target);
        if (res == -1 || res == nums.length - 1) return -1;
        return res + 1;
    }

    public static void main(String[] args) {
        SmallestLargerPositionOfTarget s = new SmallestLargerPositionOfTarget();

        int[] nums = {1, 2, 3, 3, 3, 4, 5, 6};
        System.out.println(s.smallestLargerRepeated(nums, 3));
    }
}
