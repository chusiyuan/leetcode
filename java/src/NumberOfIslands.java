//给定一个由 '1'（陆地）和 '0'（水）组成的的二维网格，计算岛屿的数量。
//一个岛被水包围，并且它是通过水平方向或垂直方向上相邻的陆地连接而成的。你可以假设网格的四个边均被水包围。
//        示例 1:
//        输入:
//        11110
//        11010
//        11000
//        00000
//        输出: 1
//        示例 2:
//        输入:
//        11000
//        11000
//        00100
//        00011
//        输出: 3
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/number-of-islands
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class NumberOfIslands {
    int m, n;
    int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        m = grid.length;
        n = grid[0].length;
        int result = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }

    public void dfs(char[][] grid, int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == '0') {
            return;
        }
        grid[r][c] = '0';
        for (int[] direction : directions) {
            dfs(grid, r + direction[0], c + direction[1]);
        }
    }

    public static void main(String[] args) {
        NumberOfIslands solution = new NumberOfIslands();
        char[][] grid = {{'1', '1', '1', '1', '0'}, {'1', '1', '0', '1', '0'}, {'1', '1', '0', '0', '0'}, {'0', '0', '0', '0', '0'}};
        System.out.println(solution.numIslands(grid));
    }
}
