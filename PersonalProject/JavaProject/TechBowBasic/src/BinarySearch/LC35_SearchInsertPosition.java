package BinarySearch;

/**
 * @Author Yi Liu
 * @Date 8/18/24
 * @SpecificTime 9:10 PM
 */
public class LC35_SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int l = 0;
        int r = nums.length - 1;
        if (nums[l] >= target) return l; //最小值都比target大，target只能放在position 0
        if (nums[r] == target) return r; //最大值和target相等，target放在position end
        if (nums[r] < target) return r + 1; //最大值都比target小，target只能放在position end 之后

        while (l + 1 < r) {//找位置 肯定是边界
            int m = l + (r - l)/2;
            if(nums[m] == target) return m;
            else if (nums[m] < target) l = m;
            else r = m;
        }

        if (nums[l] == target) return l;
        if (nums[r] == target) return r;
        return l + 1;
    }
}
