package LeetCode.SwardOffer.I;

public class Offer11 {
    public int minArray(int[] numbers) {
        //只有一组逆序对
        int n = numbers.length;
        for (int i = 1; i < n; i++) {
            if (numbers[i] < numbers[i - 1]) {
                return numbers[i];
            }
        }
        return numbers[0];

    }
}
