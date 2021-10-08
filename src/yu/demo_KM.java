package yu;

public class demo_KM {
    public static void main(String[] args) {
        int[] arr = {0, 0, 2, 2, 2, 2, 3, 3, 3, 3};
        findKM(arr, 2, 4);
    }

    public static void findKM(int[] arr, int k, int m) {
        int[] t = new int[32];
        for (int i = 0; i < 32; i++) {
            for (int num : arr) {
                t[i] += (num >> i) & 1;
            }
        }

        int ans = 0;
        boolean flag = true;

        for (int i = 0; i < 32; i++) {
            if (t[i] % m == 0) {
                continue;
            }
            if (t[i] % k == 0) {
                ans |= (1 << i);
            } else {
                flag = false;
                break;
            }
        }
        if (ans == 0) {
            int count = 0;
            for (int num : arr) {
                if (num == 0) {
                    count++;
                }
            }
            if (count == k) {
                flag = true;
            } else {
                flag = false;
            }
        }
        System.out.println(flag ? ans : "SB");
    }

}
