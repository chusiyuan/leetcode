#include<string>
#include<stack>
#include<iostream>
using namespace std;

// https://leetcode-cn.com/problems/valid-parentheses/

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