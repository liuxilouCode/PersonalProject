/**
 * @Author Yi Liu
 * @Date 7/21/22
 * @SpecificTime 4:30 PM
 */
public class FirstPosition {
    public static int firstPosition(int[] arrays, int target){
        //corner case
        if (arrays == null || arrays.length == 0){ return -1;}
        int left = 0;
        int right = arrays.length-1;
        while (left + 1 < right){
            int mid = left + (right-left)/2;
            if (arrays[mid] < target){
                left = mid;
            }
            /**这里很容易陷入经典二分法的陷阱
             *             if (arrays[mid]>target){
             *                 right = mid;
             *             }
             *             然而我现在是找边界，那我就算 arrays[mid] = target 也并不想return mid
             *             而是希望right = mid，从而找到边界
             *             从而避免 1，3，3，3，3，3，9， 假设我们想找第一个3，而arrays[mid]=3直接return mid的问题
             */

            else right = mid;
            /**
             * 这个else条件包含了 arrays[mid] >= target 这里的大于非常巧妙，是防止右边界先遇到target直接返回，然而这可能并非是第一个
             * 例如 3，3，3，3，3，3，9
             */
        }
        //post processing 是重点 一定要遵从先看左再看右的顺序
        //这里涉及到问题的逻辑。我们要找的是first position，假设arrays 是 {3,3,3,3} 那先看右会直接return index=3，然而第一个position是index = 0
        if (arrays[left] == target){ return left;}
        if (arrays[right] == target){return right;}
        return -1;
        //那么实际上，做到这里我们也就等于也知道了last position of target
    }
}
