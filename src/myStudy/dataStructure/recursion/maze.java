package myStudy.dataStructure.recursion;

public class maze {
    public static void main(String[] args) {
        int[][] map = new int[8][7];
        for (int i = 0; i < 7; i++) {//设置周围围墙
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i = 0; i < 8; i++) {//设置周围围墙
            map[i][0] = 1;
            map[i][6] = 1;
        }
        //设置挡板
        map[3][1] = 1;
        map[3][2] = 1;
        setWay(map, 1, 1);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * @param map 迷宫
     * @param i   起始点
     * @param j   起始点
     * @return 是否找到通路
     * 按照下->右->上->左的策略寻找，走不通再回溯
     */
    public static boolean setWay(int[][] map, int i, int j) {
        if (i == 4 && j == 1) {//结束条件
            map[i][j] = 6;
            return true;
        }
        if (map[i][j] == 0) {//这个点没走过
            map[i][j] = 2;//走过的路
            if (setWay(map, i + 1, j)) {
                return true;
            } else if (setWay(map, i, j + 1)) {
                return true;
            } else if (setWay(map, i - 1, j)) {
                return true;
            } else if (setWay(map, i, j - 1)) {
                return true;
            } else {
                map[i][j] = 3;
                return false;
            }
        } else {//这个点走过了or是墙or走不通
            return false;
        }

    }
}
