package Problems;
import java.util.Arrays;
/**
 * @Author Yi Liu
 * @Date 8/2/22
 * @SpecificTime 11:46 PM
 * Find K closest pairs from the origin.
 */
public class FindKClosestPairs {
    //we need a helper function to find the distance
    public int[][] kClosestPairs(int[][] pairs,int k){
        //the goal is to keep the code dry
        //corner case
        if (pairs == null || pairs.length < k){return null;}
        else if (pairs.length == k){return pairs;}
        int n = pairs.length;
        int[] distance = new int[n];
        for (int i = 0; i < n; i++){
            distance[i] = distanceHelper(pairs[i]);
        }
        Arrays.sort(distance);
        int distK = distance[k-1];
        int index = 0;
        int[][] result = new int[k][2];
        for (int j = 0; j < n; j++){
            if (distanceHelper(pairs[j]) <= distK){
                result[index++] = pairs[j];
             }
        }
        return result;
    }

    public int distanceHelper(int[] pair){
        return pair[0]*pair[0] + pair[1]*pair[1];
        //in fact this is not the distance
    }
}
