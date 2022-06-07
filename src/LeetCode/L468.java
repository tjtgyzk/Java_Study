package LeetCode;

public class L468 {
    public String validIPAddress(String queryIP) {
        return isIPv4(queryIP) ? "IPv4" : isIPv6(queryIP) ? "IPv6" : "Neither";
    }

    public boolean isIPv4(String queryIP) {
        if (queryIP.length() == 0 || queryIP.charAt(queryIP.length() - 1) == '.') {
            return false;
        }
        String[] split = queryIP.split("\\.");
        if (split.length != 4) {
            return false;
        }
        for (String s : split) {
            if (s.length() > 3 || s.length() < 1 || (s.charAt(0) == '0' && s.length() > 1)) {
                return false;
            }
            int num = 0;
            for (int i = 0; i < s.length(); i++) {
                if (!Character.isDigit(s.charAt(i))) {
                    return false;
                }
                num = 10 * num + (s.charAt(i) - '0');
            }
            if (num > 255 || num < 0) {
                return false;
            }
        }
        return true;
    }

    public boolean isIPv6(String queryIP) {
        if (queryIP.length() == 0 || queryIP.charAt(0) == ':' || queryIP.charAt(queryIP.length() - 1) == ':') {
            return false;
        }
        String[] split = queryIP.split(":");
        if (split.length != 8) {
            return false;
        }
        for (String s : split) {
            if (s.length() > 4 || s.length() < 1) {
                return false;
            }
            s = s.toLowerCase();
            for (int i = 0; i < s.length(); i++) {
                if (!Character.isDigit(s.charAt(i)) && !(s.charAt(i) >= 'a' && s.charAt(i) <= 'f')) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new L468().validIPAddress("192.168.0.1"));
    }
}
