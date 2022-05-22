package LeetCode.SwardOffer.I;

public class Offer67 {
    public int strToInt(String str) {
        str = str.strip();
        if (str == null || str.length() == 0) {
            return 0;
        }
        boolean belowZero = false;
        int numIndex = 0;
        if (str.charAt(numIndex) == '-') {
            belowZero = true;
            numIndex++;
        } else if (str.charAt(numIndex) == '+') {
            numIndex++;
        }
        int ans = 0;
        while (numIndex < str.length()) {
            if (str.charAt(numIndex) < '0' || str.charAt(numIndex) > '9') {
                return belowZero ? -ans : ans;
            }
            if (ans > 214748364) {
                return belowZero ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            } else if (ans == 214748364) {
                int over = belowZero ? 8 : 7;
                if (str.charAt(numIndex) - '0' > over) {
                    return belowZero ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                } else {
                    ans = 10 * ans + (str.charAt(numIndex) - '0');
                }
            } else {
                ans = 10 * ans + (str.charAt(numIndex) - '0');
            }
            numIndex++;
        }
        return belowZero ? -ans : ans;
    }

    public static void main(String[] args) {
        System.out.println(new Offer67().strToInt("-2147483647"));
    }
}
