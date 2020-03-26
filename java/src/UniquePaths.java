//一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
//机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
//问总共有多少条不同的路径？
//        示例 1:
//        输入: m = 3, n = 2
//        输出: 3
//        解释:
//        从左上角开始，总共有 3 条路径可以到达右下角。
//        1. 向右 -> 向右 -> 向下
//        2. 向右 -> 向下 -> 向右
//        3. 向下 -> 向右 -> 向右
//        示例 2:
//        输入: m = 7, n = 3
//        输出: 28 
//        提示：
//        1 <= m, n <= 100
//        题目数据保证答案小于等于 2 * 10 ^ 9
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/unique-paths
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.Arrays;

public class UniquePaths {
//    private int result = 0;
//    private int m,n;
//    public int uniquePaths(int m, int n) {
//        this.m = m;
//        this.n = n;
//        dfs(0,0);
//        return result;
//    }
//    public void dfs(int r, int c) {
//        if (r>=n||c>=m)return;
//        if (r==n-1&&c==m-1)result++;
//        else{
//            dfs(r+1,c);
//            dfs(r,c+1);
//        }
//    }

    public int uniquePaths(int m, int n) {
        int a = m + n - 2;
        int b = m - 1;
        long result = 1;
        for (int i = 1; i <= b; i++) {
            result = result * (a - b + i) / i;
        }
        return (int) result;
    }

    public int uniquePaths1(int m, int n) {
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }
}
