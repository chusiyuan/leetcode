//https://leetcode-cn.com/problems/game-of-life/

public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cur = board[i][j];
                int scount = 0;
                for (int k = -1; k <= 1; k++) {
                    for (int l = -1; l <= 1; l++) {
                        if (i + k < 0 || i + k >= m || j + l < 0 || j + l >= n) continue;
                        if (!(k == 0 && l == 0)) {
                            if (board[i + k][j + l] == 1 || board[i + k][j + l] == -1) {
                                scount++;
                            }
                        }
                    }
                }
                if (cur == 1 && (scount < 2 || scount > 3)) {
                    board[i][j] = -1;
                }
                if (cur == 0 && (scount == 3)) {
                    board[i][j] = 2;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == -1) {
                    board[i][j] = 0;
                }
                if (board[i][j] == 2) {
                    board[i][j] = 1;
                }
            }
        }
    }
}
