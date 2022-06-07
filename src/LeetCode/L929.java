package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class L929 {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] split = email.split("@");
            String name = split[0];
            String url = split[1];
            name = name.replaceAll("\\.", "");
            int i = name.indexOf("+");
            if (i != -1) {
                name = name.substring(0, i);
            }
            String thisUrl = name + "@" + url;
            set.add(thisUrl);
        }
        return set.size();
    }

    public static void main(String[] args) {
        System.out.println(new L929().numUniqueEmails(new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com", "testemail+david@lee.tcode.com"}));
    }
}
