package LeetCode;

public class L1823 {
    public int findTheWinner(int n, int k) {
        //约瑟夫环问题
        //第一次,从1开始数,第k个孩子被淘汰,走了k-1步
        //即n个孩子中第(k-1)%n个孩子被淘汰,从第(k-1)%n+1个孩子开始
        //第二次,n-1个孩子,从(k-1)%n+1个孩子开始,假设在该情况下存活的孩子位置为x(f(n-1,k)--从1开始数,数到x个即为答案,走了x-1步)
        //找出它在第一次中的位置,为第二次起始点往后数(x-1)%n(防止走超)个数
        //故有f(n,k) = ((k-1)%n + 1) + (x-1)%n = (k+x-1)%n = (k+f(n-1,k)-1)%n
        //从第一个开始数,走了(k+f(n-1,k)-1)%n步,故结果为1+(k+f(n-1,k)-1)%n
        if (n == 1) {
            return 1;
        }
        return 1 + (k + findTheWinner(n - 1, k) - 1) % n;

    }
}
