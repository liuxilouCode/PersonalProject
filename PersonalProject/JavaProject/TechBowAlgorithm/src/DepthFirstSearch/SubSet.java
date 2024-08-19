package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Yi Liu
 * @Date 8/13/22
 * @SpecificTime 2:43 PM
 * 利用dfs实现以下功能
 * 给定一个无重复数字/元素的数组，该功能可以给出该数组的全部（且不重复的）子集
 * 例如 [1,2,3]的全部子集为[](空集),[1],[2],[3],[1,2],[1,3],[2,3],[1,2,3]
 */
public class SubSet {
    public static List<String> subSets(char[] Set){
        List<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        dfsHelper(Set,0,sb,result);
        return result;
    }

    private static void dfsHelper(char[] array, int index, StringBuilder sb, List<String> result){
        result.add(sb.toString()); //always use deep copy here

        for (int i = index; i < array.length; i ++){
            sb.append(array[i]);
            dfsHelper(array,i+1,sb,result);
            //wall
            sb.deleteCharAt(sb.length()-1); //back tracking发生在这里
        }
        /**
         * dfs helper的目的是把整个数组看成一个数，根节点是空子集，然后第一层是a,b,c 利用dfs的特性
         * 把和a能组成子集合的全列出来，再利用最后删除的功能，达到不重复列出子集合的功能
         * 这利用了back tracking的逻辑
         * level 0                              {}
         * level 1          {a}                {b}        {c}
         * level 2    {a,b}    {a,c}       {b,c}
         * level 3 {a,b,c}
         *
         * 这也就是为什么 结果的顺序是
         * [，a,ab,abc,ac,b,bc,c] 即先遍历完最外层左子树，后遍历左子树的右子树，最后遍历根节点的右子树（左叉优先）
         */
    }

    //用同样的逻辑，我们可以做不同的数据类型

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> helper = new ArrayList();
        List<List<Integer>> res = new ArrayList();
        dfsHelper(nums,0,helper,res);
        return res;
    }

    private void dfsHelper(int[] nums, int index, List<Integer> helper, List<List<Integer>>res){
        res.add(new ArrayList(helper)); //deep copy
        for (int i = index; i <nums.length;i++){
            helper.add(nums[i]);
            dfsHelper(nums,i+1,helper,res);
            helper.remove(helper.size()-1);
        }
    }

    public static void main(String[] args) {
        //test
        char[] set = {'a','b','c'};
        System.out.println(subSets(set));

    }
}
