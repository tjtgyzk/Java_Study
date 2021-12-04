package yu.Recursion;

public class HanNuoTa {
    public static void LeftToRight(int n) {
        if (n == 1) {
            System.out.println("A-->C");
            return;
        }
        LeftToMid(n - 1);
        System.out.println("A-->C");
        MidToRight(n - 1);
    }

    public static void LeftToMid(int n) {
        if (n == 1) {
            System.out.println("A-->B");
            return;
        }
        LeftToRight(n - 1);
        System.out.println("A-->B");
        RightToMid(n - 1);
    }

    public static void MidToRight(int n) {
        if (n == 1) {
            System.out.println("B-->C");
            return;
        }
        MidToLeft(n - 1);
        System.out.println("B-->C");
        LeftToRight(n - 1);
    }

    public static void RightToMid(int n) {
        if (n == 1) {
            System.out.println("C-->B");
            return;
        }
        RightToLeft(n - 1);
        System.out.println("C-->B");
        LeftToMid(n - 1);
    }

    public static void RightToLeft(int n) {
        if (n == 1) {
            System.out.println("C-->A");
            return;
        }
        RightToMid(n - 1);
        System.out.println("C-->A");
        MidToLeft(n - 1);
    }

    public static void MidToLeft(int n) {
        if (n == 1) {
            System.out.println("B-->A");
            return;
        }
        MidToRight(n - 1);
        System.out.println("B-->A");
        RightToLeft(n - 1);
    }

    public static void hanNuoTa(int n, char from, char to, char help) {
        if (n == 1) {
            System.out.println(from + "-->" + to);
            return;
        }
        hanNuoTa(n - 1, from, help, to);
        System.out.println(from + "-->" + to);
        hanNuoTa(n - 1, help, to, from);

    }

    public static void main(String[] args) {
        LeftToRight(3);
        System.out.println("------------------------------------");
        hanNuoTa(3, 'A', 'C', 'B');
    }


}
