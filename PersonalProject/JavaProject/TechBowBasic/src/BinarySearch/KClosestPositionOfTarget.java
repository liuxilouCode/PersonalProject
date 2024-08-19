package BinarySearch;

/**
 * @Author Yi Liu
 * @Date 8/18/24
 * @SpecificTime 8:40 PM
 *
 * target may or may not exist in the array
 */
public class KClosestPositionOfTarget {
    public int[] kClosestPosition(int[] nums, int target, int k) {
        int[] res = new int[k];
        if (nums == null || nums.length == 0) return new int[] {};
        int l = 0;
        int r = nums.length - 1;
        if (nums.length <= k) return nums;
        int idx = -1;

        while (l + 1 < r) {
            int m = l + (r - l)/2;
            if (nums[m] == target){
                idx = m;
                break;
            }
            else if (nums[m] < target) l = m;
            else r = m;
        }

        if (idx == -1) {
            idx = Math.abs(nums[l] - target) > Math.abs(nums[r] - target) ? r : l;
        }
        
        res[0] = nums[idx];
        int i = idx - 1, j = idx + 1;
        int pos = 1;
        while (i >= 0 && j <= nums.length - 1) {
            if (Math.abs(nums[i] - target) > Math.abs(nums[j] - target)) {
                res[pos] = nums[i];
                i--;
            } else {
                res[pos] = nums[j];
                j++;
            }
            pos++;
        }

        while (pos < k) {
            if (i < 0) {
                res[pos] = nums[j];
                j++;
            } else {
                res[pos] = nums[i];
                i--;
            }
            pos++;
        }
        return res;
    }
}
