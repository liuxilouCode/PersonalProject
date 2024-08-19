package BinarySearch;

/**
 * @Author Yi Liu
 * @Date 8/18/24
 * @SpecificTime 9:13 PM
 * Given a 0-indexed integer array nums, find a peak element, and return its index.
 * If the array contains multiple peaks, return the index to any of the peaks.
 * An element is always considered to be strictly greater than a neighbor that is outside the array.
 */
public class LC162_FindPeakElement {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0;
        int r = nums.length - 1;
        if (r == 0) return 0;
        if (nums[l] > nums[l + 1]) return l;
        if (nums[r] > nums[r - 1]) return r;

        while (l + 1 < r) {
            int m = l + (r - l)/2;
            if (nums[m] > nums[m + 1] && nums[m - 1] < nums[m]) return m;
            else if (nums[m] < nums[m + 1]) l = m;
            else if (nums[m] > nums[m + 1]) r = m;
        }
        return nums[l] < nums[r] ? r : l;
    }
}
