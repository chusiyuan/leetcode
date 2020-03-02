//给定一个字符串和一个字符串字典，找到字典里面最长的字符串，该字符串可以通过删除给定字符串的某些字符来得到。如果答案不止一个，返回长度最长且字典顺序最小的字符串。如果答案不存在，则返回空字符串。
//        示例 1:
//        输入:
//        s = "abpcplea", d = ["ale","apple","monkey","plea"]
//        输出:
//        "apple"
//        示例 2:
//        输入:
//        s = "abpcplea", d = ["a","b","c"]
//        输出:
//        "a"
//        说明:
//        所有输入的字符串只包含小写字母。
//        字典的大小不会超过 1000。
//        所有输入的字符串长度不会超过 1000。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/longest-word-in-dictionary-through-deleting
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.List;

public class LongestWordInDictionaryThroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        int maxLen = 0;
        String result = "";
        for (String str : d){
            int i = 0;
            int j = 0;
            while (str.length()>=maxLen&&j<str.length()&&i<s.length()){
                if (s.charAt(i)==str.charAt(j)){
                    i++;
                    j++;
                }else{
                    i++;
                }
            }
            if (j==str.length()){
                if ((str.length()==maxLen&&str.compareTo(result)<0)||str.length()>maxLen){
                    maxLen=str.length();
                    result= str;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String a="";
        String b="a";
        System.out.println(a.compareTo(b));
    }
}
