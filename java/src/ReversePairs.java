//https://leetcode-cn.com/problems/shu-zu-zhong-de-ni-xu-dui-lcof/

public class ReversePairs {
    public int reversePairs(int[] nums) {
        int len = nums.length;
        if (len == 0 || len == 1) return 0;
        int[] dp = new int[len];
        for (int i = 1; i < len; i++) {
            dp[i] = dp[i-1];
            for (int j = 0; j < i; j++) {
                if (nums[j] > nums[i]) {
                    dp[i]++;
                }
            }
        }
        return dp[len-1];
    }
}
