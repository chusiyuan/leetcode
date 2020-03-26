//给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。
// 转换需遵循如下规则：
//        每次转换只能改变一个字母。
//        转换过程中的中间单词必须是字典中的单词。
//        说明:
//        如果不存在这样的转换序列，返回 0。
//        所有单词具有相同的长度。
//        所有单词只由小写字母组成。
//        字典中不存在重复的单词。
//        你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
//        示例 1:
//        输入:
//        beginWord = "hit",
//        endWord = "cog",
//        wordList = ["hot","dot","dog","lot","log","cog"]
//        输出: 5
//        解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
//        返回它的长度 5。
//        示例 2:
//        输入:
//        beginWord = "hit"
//        endWord = "cog"
//        wordList = ["hot","dot","dog","lot","log"]
//        输出: 0
//        解释: endWord "cog" 不在字典中，所以无法进行转换。
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/word-ladder
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (!wordList.contains(endWord)) return 0;
        Queue<String> queue = new LinkedList<>();
        boolean[] visited = new boolean[wordList.size()];
        int result = 1;
        queue.add(beginWord);
        int index = wordList.indexOf(beginWord);
        if (index!=-1){
            visited[index]=true;
        }
        while (!queue.isEmpty()){
            result++;
            int size = queue.size();
            while (size-->0){
                String cur = queue.poll();
                for (int i = 0; i<wordList.size();i++){
                    if (visited[i]){
                        continue;
                    }
                    if (!canConvert(cur,wordList.get(i))){
                        continue;
                    }
                    if (wordList.get(i).equals(endWord)){
                        return result;
                    }
                    visited[i]=true;
                    queue.add(wordList.get(i));
                }
            }
        }
        return 0;
    }
    public boolean canConvert(String str1, String str2){
        int diffNum = 0;
        for (int i = 0; i<str1.length();i++){
            if (str1.charAt(i)!=str2.charAt(i)){
                diffNum++;
            }
            if (diffNum>1)break;
        }
        return diffNum==1;
    }
}
