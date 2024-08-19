import java.util.Random;
/**
 * @Author Yi Liu
 * @Date 7/29/22
 * @SpecificTime 5:33 PM
 */
public class TestRandom {
    public static void main(String[] args) {
        Random rand = new Random();
        int random = rand.nextInt(1,81);
        System.out.println(random);
    }
}
