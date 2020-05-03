//https://leetcode-cn.com/problems/maximum-nesting-depth-of-two-valid-parentheses-strings/

public class MaxDepthAfterSplit {
    public int[] maxDepthAfterSplit(String seq) {
        int[] ans = new int[seq.length()];
        int d = 0;
        for (int i = 0; i < seq.length(); i++) {
            if (seq.charAt(i)=='(') {
                d++;
                ans[i] = d % 2;
            } else {
                ans[i] = d % 2;
                d--;
            }
        }
        return ans;
    }
}
