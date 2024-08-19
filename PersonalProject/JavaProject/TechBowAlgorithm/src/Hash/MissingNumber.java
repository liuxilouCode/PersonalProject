package Hash;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author Yi Liu
 * @Date 8/4/22
 * @SpecificTime 6:51 PM
 * Given an array nums containing n distinct numbers in the range[0,n], return only the number in the
 * range that is missing from the array
 */
public class MissingNumber {
    //mathematically there is a very easy way to solve this problem
    //the sum of consecutive n natural number is (n(n+1))/2
    public static int missingNumber(int[] nums){ //todo long
        int n = nums.length;
        int expectedSum = (n*(n+1))/2;
        int realSum=0;
        for (int num:nums){
            realSum +=num;

        }
        return expectedSum-realSum;

    }
    //time complexity is O(n) and space complexity is O(1)

    //another approach is hash set
        public int missingNumberHash(int[] nums) {
            Set<Integer> numSet = new HashSet<Integer>();
            for (int num : nums) numSet.add(num);

            int expectedNumCount = nums.length + 1;
            for (int number = 0; number < expectedNumCount; number++) {
                if (!numSet.contains(number)) {
                    return number;
                }
            }
            return -1;
        }


}
