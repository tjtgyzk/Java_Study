package myStudy.dataStructure.sort;

import java.util.Arrays;

public class duiShuQi {
    public static void main(String[] args) {
        int maxSize = 10;
        int maxValue = 10;
        int testTime = 10000;
        boolean flag = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr = getRandomArray(maxSize, maxValue);
            int[] arr1 = arr;
            int[] arr2 = arr;
            select.SelectSort(arr1);
            Arrays.sort(arr2);
            if (!arr1.equals(arr2)) {
                flag = false;
                System.out.println(Arrays.toString(arr));
            }
        }
        System.out.println(flag ? "Right" : "Wrong");

    }

    public static int[] getRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) (Math.random() * (maxValue + 1))];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * (maxValue + 1)) - (int) (Math.random() * (maxValue + 1));
        }
        return arr;
    }
}
