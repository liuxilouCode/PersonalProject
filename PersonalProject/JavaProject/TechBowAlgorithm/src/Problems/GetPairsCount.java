package Problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author Yi Liu
 * @Date 8/8/22
 * @SpecificTime 7:05 PM
 * 同一个
 */
public class GetPairsCount {
    public static int getPairsCount(List<Integer> price)
    {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int size = price.size();
        // Store counts of all elements in map hm
        for (int i = 0; i < size; i++) {
            // initializing value to 0, if key not found
            hm.put(price.get(i)%3, hm.getOrDefault(price.get(i)%3,0)+1);
        }

        int result  = hm.get(1)*hm.get(2)+(hm.get(0)*hm.get(0)-1)/2;
        return result;
    }

    public static int countPair(List<Integer> price) {

        Map<Integer, Integer> priceMap = new HashMap<>();
        int n = price.size();
        for (int i = 0; i < n; i++)
            priceMap.put(price.get(i), priceMap.getOrDefault(price.get(i), 0) + 1);
        int ans = 0;
        for (int i = 1; i < 19; i++) {

            int key = (int) Math.pow(3, i);
            for (int j = 0; j < n; j++) {
                int k = key - price.get(j);
                ans += priceMap.getOrDefault(k, 0);
            }
        }
        return ans/2;
    }

    public static void main(String[] args) {
        List<Integer> test = new ArrayList<>();
        test.add(4);
        test.add(5);
        test.add(4);
        test.add(5);
        test.add(3);
        test.add(6);
        test.add(9);
        test.add(9);
        System.out.println(getPairsCount(test));
        System.out.println(countPair(test));
    }

}
