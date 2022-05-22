package LeetCode.SwardOffer.I;

public class Offer12 {
    public boolean exist(char[][] board, String word) {
        if (word.length() == 0) {
            return true;
        }
        boolean flag = false;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                flag |= process(board, word, i, j);
            }
        }
        return flag;
    }

    public boolean process(char[][] board, String rest, int i, int j) {
        if (rest.length() == 0) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return false;
        }
        boolean flag = false;
        if (board[i][j] == rest.charAt(0)) {
            char cur = board[i][j];
            board[i][j] = ' ';
            flag = process(board, rest.substring(1), i - 1, j) || process(board, rest.substring(1), i + 1, j) || process(board, rest.substring(1), i, j - 1) || process(board, rest.substring(1), i, j + 1);
            board[i][j] = cur;
        }
        return flag;
    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        new Offer12().exist(board, "ABCCED");
    }
}
