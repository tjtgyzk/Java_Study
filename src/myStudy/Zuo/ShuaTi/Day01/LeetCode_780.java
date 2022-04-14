package myStudy.Zuo.ShuaTi.Day01;

public class LeetCode_780 {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        return process(sx, sy, tx, ty);
    }

    /**
     * @param nx 当前出发点
     * @param ny 当前出发点
     * @param tx 目标点
     * @param ty 目标点
     * @return
     */
    public static boolean process(int nx, int ny, int tx, int ty) {
        if (nx == tx && ny == ty) {
            return true;
        }
        if (nx > tx || ny > ty) {
            return false;
        }
        return (process(nx + ny, ny, tx, ty) || process(nx, nx + ny, tx, ty));
    }

    public static boolean function(int sx, int sy, int tx, int ty) {
        while (tx > sx && ty > sy && tx != ty) {
            if (tx > ty) {
                tx %= ty;
            } else {
                ty %= tx;
            }
        }
        if (tx == sx && ty == sy) {
            return true;
        } else if (tx == sx) {
            return ty > sy && (ty - sy) % tx == 0;
        } else if (ty == sy) {
            return tx > sx && (tx - sx) % ty == 0;
        } else {
            return false;
        }

    }

    public static void main(String[] args) {
        System.out.println(function(35, 13, 455955547, 420098884));
    }
}
