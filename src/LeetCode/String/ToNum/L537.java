package LeetCode.String.ToNum;

public class L537 {
    public String complexNumberMultiply(String num1, String num2) {
        String[] nums1 = num1.split("\\+");
        String[] nums2 = num2.split("\\+");
        int real1 = Integer.parseInt(nums1[0]);
        int real2 = Integer.parseInt(nums2[0]);
        int im1 = Integer.parseInt(nums1[1].substring(0, nums1[1].length() - 1));
        int im2 = Integer.parseInt(nums2[1].substring(0, nums2[1].length() - 1));
        return String.valueOf(real1 * real2 - im1 * im2) + "+" + String.valueOf(real1 * im2 + real2 * im1) + "i";

    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("12"));
        ;
    }
}
