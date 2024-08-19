/**
 * @Author Yi Liu
 * @Date 7/23/22
 * @SpecificTime 2:30 PM
 * 我们只知道这个序列是有序序列且假设各元素不重复
 *You may only access the array using an ArrayReader interface,
 * where ArrayReader.get(k)returns the element of the array at index k (0-indexed).
 */
public class UnknownSizePosition {
    public int unknownSizePosition(ArrayReader reader, int target){ //todo long
        //todo 既让别人知道你意识到了这个问题，又没有改变原问题应有的答案
        if (reader == null){return -1;} //corner case. since size  is too large, we don't have to consider arrays.length
        int left = 0;
        int end = 1;
        while (reader.get(end) !=null && (Integer)reader.get(end)<target){
            left = end;
            end*=2; //以二倍扩张的range不断探索（probing），直到找到能包含target的边界
            //这个和避免哈希碰撞 hash collision的概念是一样的（回忆一下动力节点老韩讲hash table的课）
        }
        //然后明确target在我们的范围内了，就可以用binary search
        while (left <= end ){ //注意这里只能用左右越过的做法，因为我们并没有明确的end = arrays.length-1
            //重点是我们这次在乎的也就是index，所以左右越过的方法就足够了
            int mid = left + (end-left)/2;
            if (reader.get(mid) !=null && reader.get(mid).equals(target)){return mid;}
            else if (reader.get(mid) != null && (Integer)reader.get(mid) <target){left = mid+1;}
            else end = mid-1; //这个else中包含的条件即 reader.get(mid) == null || reader.get(mid) >target
            //这些if条件中加入reader.get(mid) !=null的判断是因为我们并不确定上一个while loop停下的条件是什么
            //有可能是reader.get(end) >= target导致while loop停下了，那end的确还在序列的长度范围内
            //但也有可能是reader.get(end) =null了导致while loop停下，这样end就不在范围内了，所以要判断一下
        }
        return -1;

    }
    /**
     * 这里留了个疑问，if条件下，一个方法的返回值如果是int，就没办法用！=null这个条件
     * 但如果可以用！=null的条件，那有没办法和一个integer比较
     * 其中一个解决办法是利用Object
     * 但是我暂时还没想出来怎么用Object去和integer比较
     *
     * 找到了方法  相等的话 可以利用Object.equals的方法
     * 大于小于的话就直接强转
     */


}

