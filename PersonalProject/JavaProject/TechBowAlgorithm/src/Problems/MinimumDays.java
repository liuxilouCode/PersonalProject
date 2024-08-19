package Problems;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author Yi Liu
 * @Date 8/14/22
 * @SpecificTime 7:09 PM
 * 有n个物流中心，minimum operations to send out all parcels
 */
public class MinimumDays {
    public static int getMinimumDays(List<Integer> parcels){
        Set<Integer> set = new HashSet<>();
        for (int x:parcels){
            if (x>0) set.add(x);
        }
        return set.size();
    }
}
