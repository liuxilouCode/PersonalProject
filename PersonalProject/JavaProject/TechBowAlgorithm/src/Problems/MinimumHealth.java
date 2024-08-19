package Problems;

import java.util.*;

/**
 * @Author Yi Liu
 * @Date 8/9/22
 * @SpecificTime 4:07 PM
 */
public class MinimumHealth {
    public static long minimumHealth(List<Integer> damage, int armor) {
        final long sum = damage.stream().mapToLong(Integer::intValue).sum();
        final long maxDamage = Collections.max(damage);
        return 1l + sum - Math.min(maxDamage, armor);
    }

    public static void main(String[] args) {
        List<Integer> power = new ArrayList<>();
        power.add(2);
        power.add(5);
        power.add(3);
        power.add(4);
        System.out.println(minimumHealth(power,7));
    }
}
