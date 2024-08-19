import java.util.Arrays;

/**
 * @Author Yi Liu
 * @Date 7/21/22
 * @SpecificTime 5:19 PM
 * 仍然利用binary search
 */
public class ClosestPosition {
    public static void main(String[] args) {
        int[] array = new int[]{3,4,5,6,9,10,11,12};
        System.out.println(closestPosition(array,6));
        int[] results = multiClosestSearch(array,6,4);
        System.out.println(Arrays.toString(results));
    }

    public static int closestPosition(int[] arrays, int target){
        //这里还是找边界最方便
        //假设我们的需求是在一组sorted且无重复元素的数组中找closest element
        if (arrays == null || arrays.length == 0){return -1;}
        int left = 0;
        int right = arrays.length-1;
        while (left + 1 < right){
            int mid = left + (right - left)/2;
            if (arrays[mid] < target) left = mid;
            else if (arrays[mid] > target) right = mid;
            else return mid;
        }
        /**
         * post processing 变了
         * 如果我们没有target，那要找最近值。那就要看哪个数和目标值的差值最小（即距离目标最近，也就是距离最短）
         * 因为是sorted array，可能产生距离为负的情况，用绝对值可以方便的处理这个方法
         *
         * return a?b:c; 三目运算符 Conditional Operator
         * 即 判断a是true还是false，若a是true，则执行b；若a是false，则执行c
         *
         * 实际上我们可以不用绝对值，即 target-arrays[left] 和  arrays[right] - target
         * 然而这样不够general
         * 代码的最高要求是general，universal，可以让代码可能处理的情况尽可能的多
         */

        return Math.abs(arrays[left] - target) < Math.abs(arrays[right] - target)? left : right;
        //若 Math.abs(arrays[left] - target) < Math.abs(arrays[right] - target) 是true，则说明arrays[left]更接近target，返回left
        //反之，返回right
    }

    //那现在我们需要返回最接近的k个
    //思路是利用上面找最近值的思路，然后双指针一个往左一个往右，一直查找
    public static int[] multiClosestSearch(int[] arrays, int target, int multiSearch){
        if (arrays == null || arrays.length ==0 || multiSearch <= 0){return null;} //corner case
        if (multiSearch >= arrays.length ){ return arrays;}
        int left = 0;
        int right = arrays.length-1;
        int[] result = new int[multiSearch];
        while (left + 1 < right){
            int mid = left + (right - left)/2;
            if (arrays[mid] < target) left = mid;
            else right = mid;
        }
        for (int i = 0; i < multiSearch; i++){
            if (right >= arrays.length || (left >= 0 && Math.abs(arrays[left] - target) < Math.abs(arrays[right] - target))){
                result[i] = arrays[left--];
                //这个条件是说，如果右边已经到头了，左边还没到头，那只有左边可以选了，选左边。短路且是代表如果短路或的某个条件没达到，
                //例如 右边没到头，但是左边也没到头且左边的距离更小，那选左边
            } else result[i] = arrays[right++]; //以上条件都不符合，只有右边可以选
        }
        int[] sortedResult = bubbleSort(result);
        return sortedResult;
        //这个方法不完美的地方在于，返回的数组并不是按大小排序的,我加了个冒泡排序
    }

    public static int[] bubbleSort(int[] arrays){
        if (arrays == null || arrays.length==0){return null;}
        boolean flg = false;
        for (int i = 0; i < arrays.length-1; i++){
            for (int j = 0; j < arrays.length-1-i;j++){
                int temp = 0;
                if (arrays[j]>arrays[j+1]){
                    temp = arrays[j+1];
                    arrays[j+1] = arrays[j];
                    arrays[j] = temp;
                    flg = true;
                }
            }
            if (!flg){break;}
            else {flg = false;}
        }
        return arrays;
    }

}
