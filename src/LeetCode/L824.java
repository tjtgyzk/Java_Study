package LeetCode;

public class L824 {
    public String toGoatLatin(String sentence) {
        String[] s = sentence.split(" ");
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            StringBuilder sb = new StringBuilder(s[i]);
            if (s[i].charAt(0) == 'a' || s[i].charAt(0) == 'e' || s[i].charAt(0) == 'i'
                    || s[i].charAt(0) == 'o' || s[i].charAt(0) == 'u' || s[i].charAt(0) == 'A'
                    || s[i].charAt(0) == 'E' || s[i].charAt(0) == 'I' || s[i].charAt(0) == 'O'
                    || s[i].charAt(0) == 'U') {
                sb.append("ma");
            } else {
                sb.append(s[i].charAt(0));
                sb.deleteCharAt(0);
                sb.append("ma");
            }
            int length = i + 1;
            while (length-- > 0) {
                sb.append("a");
            }
            ans.append(sb + " ");
        }
        ans.deleteCharAt(ans.length() - 1);
        return ans.toString();
    }
}
