//https://leetcode-cn.com/problems/as-far-from-land-as-possible/

import java.util.LinkedList;
import java.util.Queue;

public class AsFarFromLandAsPossible {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        int directions[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        boolean hasOcean = false;
        boolean hasLand = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    hasLand = true;
                    queue.add(new int[]{i, j});
                } else {
                    hasOcean = true;
                }
            }
        }
        if (!hasLand || !hasOcean) return -1;
        int result = 1;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int x = point[0];
            int y = point[1];
            for (int[] direction : directions) {
                int newX = x + direction[0];
                int newY = y + direction[1];
                if (newX < 0 || newX >= n || newY < 0 || newY >= n) continue;
                if (grid[newX][newY] == 0) {
                    grid[newX][newY] = grid[x][y] + 1;
                    queue.add(new int[]{newX, newY});
                    result = grid[newX][newY];
                }
            }
        }
        return result - 1;
    }
}
