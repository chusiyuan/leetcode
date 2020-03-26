//给定一个二维的矩阵，包含 'X' 和 'O'（字母 O）。
//找到所有被 'X' 围绕的区域，并将这些区域里所有的 'O' 用 'X' 填充。
//        示例:
//        X X X X
//        X O O X
//        X X O X
//        X O X X
//        运行你的函数后，矩阵变为：
//        X X X X
//        X X X X
//        X X X X
//        X O X X
//        解释:
//        被围绕的区间不会存在于边界上，换句话说，任何边界上的 'O' 都不会被填充为 'X'。 任何不在边界上，或不与边界上的 'O' 相连的 'O' 最终都会被填充为 'X'。如果两个元素在水平或垂直方向相邻，则称它们是“相连”的。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/surrounded-regions
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class SurroundedRegions {
    private int m, n;
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        m = board.length;
        n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < n; i++) {
            dfs(board, 0, i, visited);
            dfs(board, m - 1, i, visited);
        }
        for (int j = 0; j < m; j++) {
            dfs(board, j, 0, visited);
            dfs(board, j, n - 1, visited);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int r, int c, boolean[][] visited) {
        if (r < 0 || r >= m || c < 0 || c >= n || board[r][c] != 'O' || visited[r][c]) return;
        visited[r][c] = true;
        for (int[] direction : directions) {
            dfs(board, r + direction[0], c + direction[1], visited);
        }
    }

    public static void main(String[] args) {
        char[][] board = {{'O', 'X', 'X', 'O', 'X'}, {'X', 'O', 'O', 'X', 'O'}, {'X', 'O', 'X', 'O', 'X'}, {'O', 'X', 'O', 'O', 'O'}, {'X', 'X', 'O', 'X', 'O'}};
        SurroundedRegions solution = new SurroundedRegions();
        solution.solve(board);
    }
}
