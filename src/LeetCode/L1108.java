package LeetCode;

public class L1108 {
    public String defangIPaddr(String address) {
        char[] chars = address.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '.') {
                sb.append('[').append('.').append(']');
            } else {
                sb.append(chars[i]);
            }
        }
        return sb.toString();
    }
}
