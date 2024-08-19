package Chapter1;

import java.util.Scanner;

/**
 * @Author Yi Liu
 * @Date 8/14/24
 * @SpecificTime 4:27 PM
 */
public class JavaScannerCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input a");
        int a = sc.nextInt();
        System.out.println("input b");
        int b = sc.nextInt();

        System.out.println(a%b);
        System.out.println(Math.pow(a,b));//a的b次方
        System.out.println(a/b);
    }
}
