//给定一个 m x n 的非负整数矩阵来表示一片大陆上各个单元格的高度。
//“太平洋”处于大陆的左边界和上边界，而“大西洋”处于大陆的右边界和下边界。
//规定水流只能按照上、下、左、右四个方向流动，且只能从高到低或者在同等高度上流动。
//请找出那些水流既可以流动到“太平洋”，又能流动到“大西洋”的陆地单元的坐标。
//        提示：
//        输出坐标的顺序不重要
//        m 和 n 都小于150
//        示例：
//        给定下面的 5x5 矩阵:
//        太平洋 ~   ~   ~   ~   ~
//        ~  1   2   2   3  (5) *
//        ~  3   2   3  (4) (4) *
//        ~  2   4  (5)  3   1  *
//        ~ (6) (7)  1   4   5  *
//        ~ (5)  1   1   2   4  *
//        *   *   *   *   * 大西洋
//        返回:
//        [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (上图中带括号的单元).
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/pacific-atlantic-water-flow
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.ArrayList;
import java.util.List;

public class PacificAtlanticWaterFlow {
    private int m, n;
    private int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return result;
        m = matrix.length;
        n = matrix[0].length;
        boolean[][] visitedP = new boolean[m][n];
        boolean[][] visitedA = new boolean[m][n];
        for (int i = 0; i < n; i++) {
            dfs(matrix, 0, i, visitedP);
            dfs(matrix, m - 1, i, visitedA);
        }
        for (int i = 0; i < m; i++) {
            dfs(matrix, i, 0, visitedP);
            dfs(matrix, i, n - 1, visitedA);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visitedP[i][j] && visitedA[i][j]) {
                    List<Integer> coo = new ArrayList<>();
                    coo.add(i);
                    coo.add(j);
                    result.add(coo);
                }
            }
        }
        return result;
    }

    private void dfs(int[][] matrix, int r, int c, boolean[][] visited) {
        if (visited[r][c]) return;
        visited[r][c] = true;
        for (int[] direction : directions) {
            int nextR = r + direction[0];
            int nextC = c + direction[1];
            if (nextR < 0 || nextR >= m || nextC < 0 || nextC >= n || matrix[r][c] > matrix[nextR][nextC]) {
                continue;
            }
            dfs(matrix, nextR, nextC, visited);
        }
    }
}
