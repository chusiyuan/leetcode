//编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
//        示例 1:
//        输入: "hello"
//        输出: "holle"
//        示例 2:
//        输入: "leetcode"
//        输出: "leotcede"
//        说明:
//        元音字母不包含字母"y"。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;

public class ReverseVowelsOfAString {
    public String reverseVowels(String s) {
        if (s==null) return null;
        Set<Character> vowels = new HashSet<>(asList('a','e','i','o','u','A','E','I','O','U'));
        int left = 0;
        int right = s.length()-1;
        char[] charArray = new char[s.length()];
        while (left<=right){
            char ci = s.charAt(left);
            char cj = s.charAt(right);
            if (!vowels.contains(ci)){
                charArray[left++] = ci;
            }else if (!vowels.contains(cj)){
                charArray[right--] = cj;
            }else{
                charArray[left++] = cj;
                charArray[right--] = ci;
            }
        }
        return new String(charArray);
    }
}
