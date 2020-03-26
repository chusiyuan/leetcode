//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
//给出数字到字母的映射如下（2：abc，3：def ...）（与电话按键相同）。注意 1 不对应任何字母。
//示例:
//        输入："23"
//        输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//        说明:
//        尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    private static final String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    List<String> result = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if (digits.length()!=0) {
            backtrace("",digits);
        }
        return result;
    }
    public void backtrace(String pre, String digits) {
        if (digits.length()==pre.length()){
            result.add(pre);
        }else{
            int digit = digits.charAt(pre.length())-'0';
            String str = map[digit-2];
            for (char ch:str.toCharArray()){
                backtrace(pre+String.valueOf(ch),digits);
            }
        }
    }
}
