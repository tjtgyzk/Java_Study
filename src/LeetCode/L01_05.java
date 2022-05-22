package LeetCode;

public class L01_05 {
    public boolean oneEditAway(String first, String second) {
        if (Math.abs(first.length() - second.length()) > 1) {
            return false;
        }
        if (first.length() == second.length()) {
            int dif = 0;
            for (int i = 0; i < first.length(); i++) {
                if (first.charAt(i) != second.charAt(i)) {
                    dif++;
                }
            }
            return dif <= 1;
        }
        String longS = first.length() > second.length() ? first : second;
        String shortS = longS.equals(first) ? second : first;
        int index = -1;
        for (int i = 0; i < shortS.length(); i++) {
            if (longS.charAt(i) != shortS.charAt(i)) {
                index = i;
                break;
            }
        }
        if (index == -1) {
            //在最后插入
            return true;
        }
        StringBuilder sb = new StringBuilder();
        if (index == 0) {
            sb.append(longS.substring(1));
        } else {
            sb.append(longS.substring(0, index)).append(longS.substring(index + 1));
        }
        return sb.toString().equals(shortS);
    }

    public static void main(String[] args) {
        new L01_05().oneEditAway("teacher", "teacherly");
    }
}
