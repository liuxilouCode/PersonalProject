package RecursionTest;

/**
 * @Author Yi Liu
 * @Date 7/25/22
 * @SpecificTime 11:35 PM
 *
 * Create a method MyPower(x,n) where the return value gives you x^n
 * 拿到所有题都首先要和面试官clarify
 *  x是整数吗 n是整数吗 n可以为负吗 n可以为0吗？等等
 *  我们假设这道题的条件是n不可以为负数
 */
public class MyPower {
    public static void main(String[] args) {
        System.out.println(myBinaryPower(5,6));

    }

    public static int myPower(int x, int n){ //todo long
        if (n<0){
            throw new IllegalArgumentException();
        }
        else if(n == 0){
            return 1;
        }
        else{
            return x*myPower(x,n-1);
        }
    }
    /**
     * 如果用for loop的写法，那这个方法的时间复杂度是O（n）
     * 如果用recursion，时间复杂度也是O（n）
     * 但这样时间复杂度上没什么提升
     * 那我们能不能binary reduction
     * myPower(x,n/2)*myPower(x,n/2) 在时间复杂度方面提升一下
     */

    public static int myBinaryPower(int x, int n){ //todo long
        if (n<0){
            throw new IllegalArgumentException();
        }
        else if(n == 0){
            return 1;
        }
        else if (n==1){
            return x;
        }
        else{
            int half = myBinaryPower(x,n/2); //提前预判可能在计算中重复的值，加以利用，减少时间复杂度
            return n%2==0? half*half:half*half*x;
        }
        //时间复杂度是O(log n)
    }
}
