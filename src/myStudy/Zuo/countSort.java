package myStudy.Zuo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class countSort {
    public static void main(String[] args) {
        int[] arr = {5, 3, 2, 1, 4};
        jiSort(arr);
        System.out.println(Arrays.toString(arr));
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 1);
        map.put(1, map.get(1) + 1);
        map.remove(1);

    }

    public static void jiSort(int[] arr) {
        int max = 0;
        int min = 0;
        for (int i : arr) {
            max = Math.max(i, max);
            min = Math.min(i, min);
        }
        int temp[] = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            temp[arr[i] - min]++;
        }
        int j = 0;
        for (int i = 0; i < temp.length; i++) {
            while (temp[i]-- > 0) {
                arr[j++] = i + min;
            }
        }
    }
}
