//给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。你需要让组成和的完全平方数的个数最少。
//        示例 1:
//        输入: n = 12
//        输出: 3
//        解释: 12 = 4 + 4 + 4.
//        示例 2:
//        输入: n = 13
//        输出: 2
//        解释: 13 = 4 + 9.
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/perfect-squares
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class PerfectSquares {
    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();
        queue.add(0);
        visited.add(0);
        int result = 0;
        while (!queue.isEmpty()) {
            result++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (int j = 1; j * j + cur <= n; j++) {
                    int next = j * j + cur;
                    if (next == n) return result;
                    if (next < n && !visited.contains(next)) {
                        visited.add(next);
                        queue.add(next);
                    }
                }
            }
        }
        return result;
    }
}
