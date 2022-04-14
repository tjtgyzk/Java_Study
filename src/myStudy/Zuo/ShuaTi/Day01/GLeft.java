package myStudy.Zuo.ShuaTi.Day01;

public class GLeft {
    public static int getCount(String s) {
        char[] chars = s.toCharArray();
        int count = 0;
        int gi = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == 'G') {
                count += i - gi;
                gi++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(getCount("BB"));
    }
}
