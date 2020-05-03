//https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/

import java.util.HashMap;

public class LengthOfLongestSubstring {
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        int len = s.length();
        for (int i = 0, j = 0; j < len; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(i, map.get(s.charAt(j)) + 1);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j);
        }
        return ans;
    }
}
