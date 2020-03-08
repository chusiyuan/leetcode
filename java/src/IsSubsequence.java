//给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
//你可以认为 s 和 t 中仅包含英文小写字母。字符串 t 可能会很长（长度 ~= 500,000），而 s 是个短字符串（长度 <=100）。
//字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
//
//        示例 1:
//        s = "abc", t = "ahbgdc"
//        返回 true.
//
//        示例 2:
//        s = "axc", t = "ahbgdc"
//        返回 false.
//
//        后续挑战 :
//        如果有大量输入的 S，称作S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/is-subsequence
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

//顺着字符串t走一遍，用一个指针j指向s，如果在走t的时候发现与s的第j个字符相同，那么j后移一位，知道t中有一个字符与其匹配。
//如果最后能到s的结尾，则说明有解。时间复杂度O(len(s)+len(t))
//
//如果k多到了十亿的程度，如果每次都需要遍历T的话，效率会比较低。
//那么可以统计t每个字符出现的位置，把每一个字符出现的位置从小到大都记录在一个数组里面。
// 然后遍历s，对于s[i]，二分s[i]对应的那个数组找到符合要求的最小位置。
// 这里的要求就是，该位置需要比s[i-1]找到的位置大。
// 如果找不到就false效率为k*len(M)*log(len(t)),提高了百倍左右的效率。
//————————————————
//版权声明：本文为CSDN博主「lwgkzl」的原创文章，遵循 CC 4.0 BY-SA 版权协议，转载请附上原文出处链接及本声明。
//原文链接：https://blog.csdn.net/lwgkzl/article/details/83448717

public class IsSubsequence {
    public boolean isSubsequence(String s, String t) {
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }
//    public boolean isSubsequence(String s, String t) {
//        int index = -1;
//        for (char c : s.toCharArray()) {
//            index = t.indexOf(c, index + 1);
//            if (index == -1) {
//                return false;
//            }
//        }
//        return true;
//    }
}
