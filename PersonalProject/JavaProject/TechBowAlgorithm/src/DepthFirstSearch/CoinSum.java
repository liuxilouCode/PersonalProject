package DepthFirstSearch;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Yi Liu
 * @Date 8/15/22
 * @SpecificTime 1:31 PM
 * 也利用backtracking
 */
public class CoinSum {
    public static void dfs(int[] coins, int level, int leftBalance, int[] solution, List<int[]> result){
        //base case
        if (level == coins.length-1){
            solution[level] = leftBalance/coins[level]; //能reach到这里，说明到了最深层
            // 这行代码的写法取决于最小币种是多大
            //如果最深层是1分，那剩下多少balance，就要用多少个1分,所以solution[level] = leftBalance
            //如果最深层是xx分，那就要leftBalance/coins[level]
            //我们可以用level来判断的原因是因为最小币种是1
            //如果最小币种是3呢？最保险的方法是用balance判断
            // if(leftBalance<Collections.min(coins) || leftBalance%coins[level])
            result.add(solution.clone()); //deep copy
            return;
        }

        int num = leftBalance/coins[level]+1; //+1是因为取0个也是一种取法
        //例如，假设balance是100，取1-4个25美分是4种取法，也可以选择取0个25美分，所以是5种取法
        for (int i = 0; i < num; i++){
            solution[level] = i; //取本层coin的个数
            dfs(coins,level+1,leftBalance - i*coins[level],solution,result);
            //这里不需要做backtracking，因为同层之间无影响，跨层之间也无影响，因为是赋值操作，不是增删操作
        }
    }

    public static void main(String[] args) {
        int[] coins =  {1,5,10,25};
        int[] solution = new int[4];
        List<int[]> result = new ArrayList<>();
        dfs(coins,0,25,solution,result);
        for (int i = 0; i < result.size();i++){
            System.out.println(Arrays.toString(result.get(i)));
        }

    }
}
