//给定一个含有数字和运算符的字符串，为表达式添加括号，改变其运算优先级以求出不同的结果。
//你需要给出所有可能的组合的结果。有效的运算符号包含 +, - 以及 * 。
//        示例 1:
//        输入: "2-1-1"
//        输出: [0, 2]
//        解释:
//        ((2-1)-1) = 0
//        (2-(1-1)) = 2
//        示例 2:
//        输入: "2*3-4*5"
//        输出: [-34, -14, -10, -10, 10]
//        解释:
//        (2*(3-(4*5))) = -34
//        ((2*3)-(4*5)) = -14
//        ((2*(3-4))*5) = -10
//        (2*((3-4)*5)) = -10
//        (((2*3)-4)*5) = 10
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/different-ways-to-add-parentheses
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParenthese {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < input.length();i++){
            char ch = input.charAt(i);
            if (ch=='+'||ch=='-'||ch=='*') {
                List<Integer> left = diffWaysToCompute(input.substring(0,i));
                List<Integer> right = diffWaysToCompute(input.substring(i+1,input.length()));
                for (Integer l: left){
                    for (Integer r:right){
                        switch (ch){
                            case '+':
                                result.add(l+r);
                                break;
                            case '-':
                                result.add(l-r);
                                break;
                            case '*':
                                result.add(l*r);
                                break;
                        }
                    }
                }
            }
        }
        if (result.size()==0){
            result.add(Integer.valueOf(input));
        }
        return result;
    }
}
