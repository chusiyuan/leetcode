//https://leetcode-cn.com/problems/jump-game/

public class JumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n];
        dp[n - 1] = true;
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (dp[j] && nums[i] >= j - i) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
    }
}
