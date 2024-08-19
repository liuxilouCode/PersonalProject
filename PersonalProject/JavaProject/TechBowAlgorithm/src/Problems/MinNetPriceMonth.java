package Problems;

import java.util.List;

/**
 * @Author Yi Liu
 * @Date 8/8/22
 * @SpecificTime 4:29 PM
 */
public class MinNetPriceMonth {
    public static int minPriceMonth(List<Integer> stockPrice){
        long sum = 0;
        for (long i:stockPrice){
            sum+=i;
        }

        long minNetPrice = Integer.MAX_VALUE;
        long month = -1;
        long n = stockPrice.size();
        long leftSum = 0;
        long rightSum = sum;
        for (int i = 1; i < n; i++){
            leftSum += stockPrice.get(i-1);
            rightSum -= stockPrice.get(i-1);
            long currNet = Math.abs((leftSum/i) - (rightSum/(n-i)));
            if (minNetPrice > currNet){
                minNetPrice = currNet;
                month = i;
                if (minNetPrice == 0) break;
            }
        }
        return (int)month;
    }
}
