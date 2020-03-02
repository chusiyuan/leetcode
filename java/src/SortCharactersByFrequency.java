//给定一个字符串，请将字符串里的字符按照出现的频率降序排列。
//
//        示例 1:
//        输入:
//        "tree"
//        输出:
//        "eert"
//        解释:
//        'e'出现两次，'r'和't'都只出现一次。
//        因此'e'必须出现在'r'和't'之前。此外，"eetr"也是一个有效的答案。
//        示例 2:
//        输入:
//        "cccaaa"
//        输出:
//        "cccaaa"
//        解释:
//        'c'和'a'都出现三次。此外，"aaaccc"也是有效的答案。
//        注意"cacaca"是不正确的，因为相同的字母必须放在一起。
//        示例 3:
//        输入:
//        "Aabb"
//        输出:
//        "bbAa"
//        解释:
//        此外，"bbaA"也是一个有效的答案，但"Aabb"是不正确的。
//        注意'A'和'a'被认为是两种不同的字符。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/sort-characters-by-frequency
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SortCharactersByFrequency {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        /*
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (map.containsKey(ch)) {
                map.put(ch, map.get(ch) + 1);
            } else {
                map.put(ch, 1);
            }
        }

         */
        for (Character ch:s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        List<Character>[] lists = new ArrayList[s.length() + 1];
        for (Character key : map.keySet()) {
            int val = map.get(key);
            if (lists[val] == null) {
                lists[val] = new ArrayList<>();
            }
            lists[val].add(key);
        }
        /*
        String result = "";
        for (int i = s.length(); i > 0; i--) {
            if (lists[i] != null) {
                for (Character ch : lists[i]) {
                    for (int j = 0; j < i; j++) {
                        result += String.valueOf(ch);
                    }
                }
            }
        }
        return result;
         */
        StringBuilder result = new StringBuilder();
        for (int i = s.length(); i > 0; i--) {
            if (lists[i] != null) {
                for (Character ch : lists[i]) {
                    for (int j = 0; j < i; j++) {
                        result.append(ch);
                    }
                }
            }
        }
        return result.toString();
    }

}
