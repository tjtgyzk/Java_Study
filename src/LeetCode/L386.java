package LeetCode;

import java.util.LinkedList;
import java.util.List;

public class L386 {
    //    给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。
//    你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。
    //递归(字典树的遍历,从第二层开始,每个节点分别有0-9十个孩子,先从0开始遍历)
    static LinkedList<Integer> ans = new LinkedList<Integer>();

    public static List<Integer> function(int n) {
        //由于0不能加入队列,遍历第二层的九个数字分别作为头
        for (int i = 1; i <= 9; i++) {
            process(i, n);
        }
        return ans;
    }

    /**
     * @param cur 当前首数字
     * @param n   最大数字
     * @return
     */
    public static void process(int cur, int n) {
        if (cur > n) {
            return;
        }
        ans.add(cur);
        //递归遍历它的九个孩子,从0开始
        for (int i = 0; i <= 9; i++) {
            process(cur * 10 + i, n);
        }
    }


    //迭代
    public List<Integer> lexicalOrder(int n) {
        LinkedList<Integer> ans = new LinkedList<>();
        int cur = 1;
        //一共n个数,每次遍历加入一个数,这里的i只控制次数,与当前数字cur无关
        for (int i = 1; i <= n; i++) {
            ans.add(cur);
            //如果10倍没有溢出,则变为原来的10倍,相当于递归中下一层的第一个孩子0
            if (10 * cur <= n) {
                cur *= 10;
            } else {
                //如果*10溢出了,考虑i++,(比如11,变110溢出了,则下一个是12),如果i+1也溢出了或者i+1会导致进位(如19加一变20,但19后面应该是2),则考虑回退一位加一,(如19变1,再加一变2)
                //这里用while循环,防止多次不满足条件(比如199,1990溢出,/10变19,应该继续/10,下一个应该是2)
                while (cur + 1 > n || cur % 10 == 9) {
                    cur /= 10;
                }
                cur++;

            }
        }
        return ans;
    }


}
