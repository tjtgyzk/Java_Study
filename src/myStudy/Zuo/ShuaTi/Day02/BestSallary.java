package myStudy.Zuo.ShuaTi.Day02;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class BestSallary {
    public class Job {
        public int hard;
        public int money;

        public Job(int hard, int money) {
            this.hard = hard;
            this.money = money;
        }
    }

    public static int[] getMaxMoney(int[] hard, int[] money, int[] ability) {
        Job[] job = new Job[hard.length];
        for (int i = 0; i < job.length; i++) {
            job[i].hard = hard[i];
            job[i].money = money[i];
        }
        Arrays.sort(job, (o1, o2) -> {
            //按照能力升序排序,能力相同时按照报酬降序排序
            return o1.hard != o2.hard ? (o1.hard - o2.hard) : (o2.money - o1.money);
        });
        TreeMap<Integer, Integer> map = new TreeMap<>();
        //第一份工作为能力最低中报酬最高的,故一定会加入
        map.put(job[0].hard, job[0].money);
        //pre 为上一份进入有序表的工作
        Job pre = job[0];
        for (int i = 1; i < job.length; i++) {
            // 如果hard相等,那之前加入的节点一定money更多(已经排序过了)
            // 如果hard不相等(那一定更高),如果money更多则加入,money更少或相等的直接放弃
            if (job[i].hard != pre.hard && job[i].money > pre.money) {
                map.put(job[i].hard, job[i].money);
                pre = job[i];
            }
        }
        int[] ans = new int[ability.length];
        for (int i = 0; i < ability.length; i++) {
            //有可能为null(能力太低)
            Integer key = map.floorKey(ability[i]);
            ans[i] = (key == null ? 0 : map.get(key));
        }
        return ans;
    }
}
