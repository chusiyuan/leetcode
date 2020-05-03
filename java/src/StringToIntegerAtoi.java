//https://leetcode-cn.com/problems/string-to-integer-atoi/

public class StringToIntegerAtoi {
    public static int myAtoi(String str) {
        char[] carr = str.toCharArray();
        int i = 0;
        int len = carr.length;
        while (i < len && carr[i] == ' ') {
            i++;
        }
        if (i == len) {
            return 0;
        }
        boolean negative = false;
        if (carr[i] == '-') {
            negative = true;
            i++;
        } else if (carr[i] == '+') {
            i++;
        } else if (!Character.isDigit(carr[i])) {
            return 0;
        }
        int ans = 0;
        int limit = negative ? Integer.MIN_VALUE : -Integer.MAX_VALUE;
        while (i < len && Character.isDigit(carr[i])) {
            int digit = carr[i++] - '0';
            if (ans < (limit + digit) / 10) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            ans = 10 * ans - digit;
        }
        return negative ? ans : -ans;
    }

    public static void main(String[] args) {
        System.out.println(Math.pow(2, 31));
        System.out.println(Integer.valueOf("000123"));
        myAtoi("  0000000000012345678");
    }
}
