package Problems;

/**
 * @Author Yi Liu
 * @Date 7/27/22
 * @SpecificTime 1:48 AM
 *
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version,
 * all the versions after a bad version are also bad.
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
 * which causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which will return whether version is bad.
 * Implement a function to find the first bad version.
 * You should minimize the number of calls to the API.
 */
public class FirstBadVersion {
    //这道题最后minimize the number of calls to the API 就是最典型的希望面试者用binary search的hint
    //我当然可以一遍一遍的查array中的元素会return isBadVersion true，但最好的还是binary search
    //the first time a number occurs 这个不是找边界的问题，是一定要找到exact version

    public int firstBadVersion(int n) {

        int left = 1;
        int right = n;

        while (left < right){
            int mid = left + (right - left)/2;
            if (isBadVersion(mid)){
                right = mid; //can't use right = mid -1; because there's a chance that mid itself is the first bad version
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public boolean isBadVersion(int i){
        return false;
    }
}
