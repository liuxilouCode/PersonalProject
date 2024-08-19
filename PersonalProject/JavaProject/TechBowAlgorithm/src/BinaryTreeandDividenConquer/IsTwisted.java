package BinaryTreeandDividenConquer;

/**
 * @Author Yi Liu
 * @Date 7/31/22
 * @SpecificTime 6:20 PM
 * This is a special question combines symmetru and identity
 * The method should return true that as long as at some point, one tree is either symmetric or identical
 * to the other tree, we say it is twisted
 */
public class IsTwisted {
    public boolean isTwisted(TreeNode rootFirst, TreeNode rootSecond){
        if (rootFirst == null && rootSecond == null){return true;}
        if (rootFirst == null || rootSecond == null){return false;}
        if (rootFirst.value != rootSecond.value){return false;}
        //the important part is how to elegantly present the return statement and combine both
        //isSame and isSymmetric together
        return (isTwisted(rootFirst.left,rootSecond.left) &&
                isTwisted(rootFirst.right,rootSecond.right)) ||(
                        isTwisted(rootFirst.left,rootSecond.right) &&
                                isTwisted(rootFirst.right,rootSecond.left)
                );

        //短路或的前面是在判断二者是否为相同的tree
        //短路或的后面是在判断二者是否为镜像的tree
        //只要二者符合其一，则其为twisted
        //Time complexity is O(n^2) 4^log n so 2^(2*log n) = (2^log n)^2 = n^2
    }
}
