package Chapter1;

/**
 * @Author Yi Liu
 * @Date 8/18/24
 * @SpecificTime 3:23 PM
 */
public class isPalindrome {
    public static boolean isPalindrome(String s) {
        // write your code here
        if (s == null || s.length() == 0) return true;
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        int i = 0;
        int j = s.length() - 1;
        while(i < j) {
            char l = s.charAt(i);
            char r = s.charAt(j);

            if (Character.isDigit(l)) {
                if (Character.isDigit(r)) {
                    if (l == r) {
                        i ++;
                        j --;
                        continue;
                    }
                    return false;
                }
                return false;
            } else {
                l = Character.toUpperCase(l);
                r = Character.toUpperCase(r);
                if (l == r) {
                    i ++;
                    j --;
                    continue;
                }
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "ab2a";

        System.out.println(isPalindrome(s));
    }
}
