package LeetCode.String.ToNum;

public class L443 {
    public int compress(char[] chars) {
        //要求空间复杂度O(1)
        //如果某个字母只出现一次,则该字母在字符串中占用的长度不变
        //如果某个字母出现大于一次,比如15次,则只需要长度为1的该字母以及长度为2(重复次数的位数)的"1","5"即可,节省了15(出现次数) - 1(必须出现的一次) - 位数
        int count = 1;
        int ans = chars.length;
        //下一个可能改变的输入数组位置
        int index = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else {
                if (count != 1) {
                    String countNum = String.valueOf(count);
                    //将对应位置改成次数
                    for (int j = 0; j < countNum.length(); j++) {
                        chars[index++] = countNum.charAt(j);
                    }
                    ans -= count - 1 - countNum.length();
                    //需要将下一个不重复的字符往前拿
                    chars[index++] = chars[i];
                    count = 1;
                } else {
                    //需要将下一个不重复的字符往前拿
                    chars[index++] = chars[i];
                }
            }
        }
        //最后一个连续字符还没有改,冗余长度还没有减
        if (count != 1) {
            String countNum = String.valueOf(count);
            for (int j = 0; j < countNum.length(); j++) {
                chars[index++] = countNum.charAt(j);
            }
            ans -= count == 1 ? 0 : count - 1 - countNum.length();
        }
        return ans;
    }

    public static void main(String[] args) {
        String s1 = "abc";
        String s2 = "a" + "bc";
        String s4 = new String("abc");
        System.out.println(s1 == s2);
        System.out.println(s1 == s4.intern());
        System.out.println(s1.equals(s4));
    }
}
