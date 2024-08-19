package BinarySearch;

/**
 * @Author Yi Liu
 * @Date 8/18/24
 * @SpecificTime 9:20 PM
 * An element is always considered to be strictly greater than a neighbor that is outside the array.
 */
public class LC162Ext_FindValleyElement {
    public static int findValleyElement(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0;
        int r = nums.length - 1;
        if (r == 0) return 0;

        while (l + 1 < r) {
            int m = l + (r - l)/2;
            if (nums[m] < nums[m + 1] && nums[m - 1] > nums[m]) return m;
            else if (nums[m] < nums[m + 1]) r = m;
            else if (nums[m] > nums[m + 1]) l = m;
        }
        return nums[l] > nums[r] ? r : l;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,1,3,5,6,4};
        System.out.println(findValleyElement(nums));
    }
}
