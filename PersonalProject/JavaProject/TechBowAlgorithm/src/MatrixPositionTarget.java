/**
 * @Author Yi Liu
 * @Date 7/23/22
 * @SpecificTime 8:10 PM
 * In a (m*n) matrix (not necessarily squared so m may or may not equal to n), find the target.
 *
 * First, we need some clarifications. We want to use Binary Search method but we know it needs to be a sorted array.
 * What would a sorted matrix be? To be sorted, a matrix can be either horizontally sorted or vertically sorted or both
 * for example      1,4,7,11,15
 *                  2,5,8,12,19
 *                  3,6,9,16,22
 *
 *         or even  null
 *                  1，2，3
 *                  4，5，6 (it doesn't make sense in math but heap could store it)
 *
 *  we realize that the smallest number is at the top left corner and the largest number is at the bottom right corner
 *  so we could say the numbers in the "middle" can be considered as the element on the bottom left or top right
 *  thus, instead of binary searching, we are doing a row/column searching
 */
public class MatrixPositionTarget {
    public int[] matrixPosition(int[][] matrix,int target){
        //if (matrix == null || matrix.length == 0){ return new int[]{-1,-1}; }
        //我的corner case没有考虑到另外两种情况 matrix[0] == null 和 matrix[0].length == 0，这几个corner case的顺序是不能换的，原理同binary search
        //实际上，这两个case也只是代表性的，实际上任何一行都可能等于null或length为0，如果真的要查，那应该做一个for loop每个都查一遍
        if (matrix == null || matrix.length == 0 ||matrix[0] == null|| matrix[0].length == 0){
            return new int[]{-1,-1};
        }
        int rows = matrix.length; //命名的时候rows用了复数是因为不确定行列数，用复数更好，命名偶尔也会被面试官考到
        int cols = matrix[0].length; //第一行的长度就是矩阵的列数 the length of first row of the matrix is the amount of columns
        int start = 0; //不用left和right也是因为命名问题，matrix实际上是没用left和right的，我们只是想成一个长数组，便于理解
        int end = rows*cols - 1; //this is a trick that considers the entire matrix as a de-facto array
        while(start<=end){
            //searching for the exact number, so we use S1
            int mid = start + (end - start)/2;
            int i = mid/cols; //this transforms the array back to matrix which can give me the row index
            int j = mid%cols; //column index
            //这里不对row做除法是因为权重是col，这是一个数学上的问题
            if (matrix[i][j] == target){return new int[]{i,j};}
            else if (matrix[i][j] < target){start = mid+1;}
            else end = mid-1;
            //到底是建立变量i，j然后用matrix[i][j]好,还是直接用 matrix[mid/cols][mid%cols]好？
            //根据计算机coding style，重复使用的变量最好是单独建立一个变量，方便用，所以i，j好
            //即 keep your code dry
        }
        //因为我们做的是左右越过，不需要post processing
        return new int[]{-1,-1};
    }
    //the time complexity is O(log m*n) so it depends on the matrix size
}
