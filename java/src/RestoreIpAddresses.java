import java.util.*;

//https://leetcode-cn.com/problems/restore-ip-addresses/

public class RestoreIpAddresses {
    public List<String> restoreIpAddresses(String s) {
        int len = s.length();
        List<String> ans = new ArrayList<>();
        if (len > 12 || len < 4) return ans;
        Deque<String> path = new ArrayDeque<>(4);
        dfs(s, len, 0, 4, path, ans);
        return ans;
    }

    private void dfs(String s, int len, int begin, int part, Deque<String> path, List<String> ans) {
        if (begin == len) {
            if (part == 0) {
                ans.add(String.join(".", path));
            }
            return;
        }
        for (int i = begin; i < begin + 3; i++) {
            if (i >= len) break;
            if (part * 3 < len - i) continue;
            if (judgeIpSeg(s, begin, i)) {
                path.addLast(s.substring(begin, i + 1));
                dfs(s, len, i + 1, part - 1, path, ans);
                path.removeLast();
            }
        }
    }

    private boolean judgeIpSeg(String s, int left, int right) {
        int len = right - left + 1;
        if (len > 1 && s.charAt(left) == '0') return false;
        int sum = 0;
        while (left <= right) {
            sum = 10 * sum + s.charAt(left) - '0';
            left++;
        }
        return sum <= 255 && sum >= 0;
    }
}
