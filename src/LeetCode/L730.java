package LeetCode;

public class L730 {
    //动态规划二维，这个方法可以扩展为任意字符集：
    // 1、依旧是利用两端点的动态规划；
    // 2、首先特殊处理，长度为1的肯定是1；
    // 3、假如端点处的字符相同，那么需要考虑中间有无相同的该字符包裹的字段；
    // 4、假如没有的话，那么这俩字符可以与中间的所有回文串组成新的回文串，再加上本身回文串，以及这个字符一次、两次的新串；
    // 5、假如中间只有一个该字符，那么长度为1的字符串肯定算过了，只需要在上一条中减去但个字符的回文串即可；
    // 6、假如有超过一个该字符在中间，那么里面最外层里侧的所有回文串已经和里面最外层的字符组成过一次回文串了，这部分是多算的，减去即可；
    // 7、假如两端不同，那么利用容斥原理求得中间回文串的并集
    int mod = (int) 1e9 + 7;

    public int countPalindromicSubsequences(String s) {
        char c[] = s.toCharArray();
        long count[][][] = new long[4][c.length][c.length];//按照端点分类，因此无需去重
        for (int i = 0; i < c.length; i++) {
            count[c[i] - 'a'][i][i] = 1;
        }//长度为1的字符串
        for (int d = 1; d < c.length; d++) {
            for (int i = 0; i < c.length - d; i++) {
                for (int j = 0; j < 4; j++) {
                    char ch = (char) (j + 'a');
                    if (c[i] == ch && c[i + d] == ch) {
                        //c……c*所有的回文串，再加上c、cc
                        count[j][i][i + d] = 2;
                        for (int p = 0; p < 4; p++) {
                            count[j][i][i + d] += count[p][i + 1][i + d - 1];
                        }
                    }
                    //下边无法配对儿，，1、有单个端点符合，那么更新为含有那个端点的位置；2、否则更新为不含端点的位置
                    else if (c[i] == ch) {
                        count[j][i][i + d] = count[j][i][i + d - 1];
                    } else if (c[i + d] == ch) {
                        count[j][i][i + d] = count[j][i + 1][i + d];
                    } else {
                        count[j][i][i + d] = count[j][i + 1][i + d - 1];
                    }
                    count[j][i][i + d] %= mod;
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < 4; i++) {
            ans += count[i][0][c.length - 1];
        }
        return (int) (ans % mod);
    }
}
