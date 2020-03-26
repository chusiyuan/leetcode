//给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。
//你可以假设二维矩阵的四个边缘都被水包围着。
//找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
//        示例 1:
//        [[0,0,1,0,0,0,0,1,0,0,0,0,0],
//        [0,0,0,0,0,0,0,1,1,1,0,0,0],
//        [0,1,1,0,1,0,0,0,0,0,0,0,0],
//        [0,1,0,0,1,1,0,0,1,0,1,0,0],
//        [0,1,0,0,1,1,0,0,1,1,1,0,0],
//        [0,0,0,0,0,0,0,0,0,0,1,0,0],
//        [0,0,0,0,0,0,0,1,1,1,0,0,0],
//        [0,0,0,0,0,0,0,1,1,0,0,0,0]]
//        对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
//        示例 2:
//        [[0,0,0,0,0,0,0,0]]
//        对于上面这个给定的矩阵, 返回 0。
//        注意: 给定的矩阵grid 的长度和宽度都不超过 50。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/max-area-of-island
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class MaxAreaOfIsland {
    int m, n;
    int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        m = grid.length;
        n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                maxArea = Math.max(maxArea, dfs(grid, i, j));
            }
        }
        return maxArea;
    }

    public int dfs(int[][] grid, int r, int c) {
        if (r < 0 || r >= m || c < 0 || c >= n || grid[r][c] == 0) {
            return 0;
        }
        grid[r][c] = 0;
        int area = 1;
        for (int[] direction : directions) {
            area += dfs(grid, r + direction[0], c + direction[1]);
        }
        return area;
    }
}
