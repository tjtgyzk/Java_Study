package yu;

public class Deng {
    public static int getMin(String roads) {
        char[] chars = roads.toCharArray();
        int i = 0;
        int lights = 0;
        while (i < chars.length) {
            if (chars[i] == 'X') {
                i = i + 1;
            } else {
                lights++;
                if (i + 1 == chars.length) {
                    break;
                } else {
                    if (chars[i + 1] == 'X') {
                        i = i + 2;
                    } else {//i+1位置是.
                        i = i + 3;
                    }
                }
            }
        }
        return lights;
    }
}
