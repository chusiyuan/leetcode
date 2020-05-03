//https://leetcode-cn.com/problems/remove-k-digits/

import java.util.LinkedList;

public class RemoveKDigits {
    public String removeKdigits(String num, int k) {
        LinkedList<Character> stack = new LinkedList<>();
        for (char ch: num.toCharArray()) {
            while(!stack.isEmpty() && stack.peekLast() > ch && k > 0) {
                stack.removeLast();
                k--;
            }
            stack.addLast(ch);
        }
        for (int i = 0; i < k; i++) {
            stack.removeLast();
        }
        while(!stack.isEmpty()&&stack.peekFirst() == '0') stack.removeFirst();
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }
        if (sb.length() == 0) return "0";
        return sb.toString();
    }
}
