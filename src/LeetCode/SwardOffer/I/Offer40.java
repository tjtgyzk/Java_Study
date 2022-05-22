package LeetCode.SwardOffer.I;

import java.util.Arrays;

public class Offer40 {
    //基于快速选择思想
    //通过partition过程找出基准数下标i,如果i==k,说明i之前k个数即为所求,如果i<k,则说明基准数在右侧,递归调用右侧,同理i>k,递归调用左侧
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == arr.length) {
            return arr;
        }
        return partition(arr, k, 0, arr.length - 1);
    }

    public int[] partition(int[] arr, int k, int l, int r) {
        int standard = arr[l];
        int small = l - 1;
        int large = r + 1;
        int index = l;
        while (index < large) {
            if (arr[index] == standard) {
                index++;
            } else if (arr[index] < standard) {
                swap(arr, index++, ++small);
            } else {
                swap(arr, index, --large);
            }
        }
        //等于区下标
        index--;
        if (index == k) {
            return Arrays.copyOf(arr, k);
        } else if (index < k) {
            return partition(arr, k, index + 1, r);
        } else {
            return partition(arr, k, l, index - 1);
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
