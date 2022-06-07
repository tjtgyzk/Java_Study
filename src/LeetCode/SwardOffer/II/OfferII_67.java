package LeetCode.SwardOffer.II;

public class OfferII_67 {
    //前缀树
    public class Node {
        Node left;
        Node right;

        public Node() {
            left = null;
            right = null;
        }
    }

    Node head = new Node();

    public void insert(int num) {
        Node cur = head;
        for (int i = 30; i >= 0; i--) {
            if ((num & (1 << i)) != 0) {
                if (cur.right == null) {
                    cur.right = new Node();
                }
                cur = cur.right;
            } else {
                if (cur.left == null) {
                    cur.left = new Node();
                }
                cur = cur.left;
            }
        }
    }

    public int getMax(int num) {
        Node cur = head;
        int ans = 0;
        for (int i = 30; i >= 0; i--) {
            if ((num & (1 << i)) != 0) {
                if (cur.left != null) {
                    ans |= (1 << i);
                    cur = cur.left;
                } else {
                    cur = cur.right;
                }
            } else {
                if (cur.right != null) {
                    ans |= (1 << i);
                    cur = cur.right;
                } else {
                    cur = cur.left;
                }
            }
        }
        return ans;
    }

    public int findMaximumXOR(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            insert(nums[i]);
            ans = Math.max(ans, getMax(nums[i]));
        }
        return ans;
    }

    public static void main(String[] args) {
        new OfferII_67().findMaximumXOR(new int[]{3, 4});
        System.out.println(3 & (1 << 1));
    }
}
