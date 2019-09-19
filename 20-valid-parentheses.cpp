#include<string>
#include<stack>
#include<iostream>
using namespace std;

/*
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

有效字符串需满足：

左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
注意空字符串可被认为是有效字符串。

示例 1:

输入: "()"
输出: true
示例 2:

输入: "()[]{}"
输出: true
示例 3:

输入: "(]"
输出: false
示例 4:

输入: "([)]"
输出: false
示例 5:

输入: "{[]}"
输出: true

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/valid-parentheses
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */

class Solution 
{
public:
    bool isValid(string s) 
    {
        stack<char> stack;
        stack.push('#');
        for(int i = 0; i < s.length(); i++)
        {
            if (s[i] == '(' || s[i] == '[' || s[i] == '{') stack.push(s[i]);
            else if (s[i] == ')')
            {
                if (stack.top() == '(') stack.pop();
                else return false;
            }
            else if (s[i] == ']')
            {
                if (stack.top() == '[') stack.pop();
                else return false;
            }
            else if (s[i] == '}')
            {
                if (stack.top() == '{') stack.pop();
                else return false;
            }
            
        }
        if (stack.top() == '#') return true;
        else return false;
        
    }
};

int main()
{
    Solution solution;
    if(solution.isValid("]")) cout<<"valid"<<endl;
    else cout<<"invalid"<<endl;
    
}