#include<iostream>
using namespace std;
// https://leetcode-cn.com/problems/add-two-numbers/


 // Definition for singly-linked list.
struct ListNode {
    int val;
    ListNode *next;
    ListNode(int x) : val(x), next(NULL) {}
};

class Solution {
public:
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        ListNode *result = new ListNode(0), *p = result;
        int carry = 0;
        while (l1 != NULL || l2 != NULL || carry)
        {
            int temp = 0;
            if (l1 != NULL)
            {
                temp += l1 -> val;
                l1 = l1 -> next;
            }
            if (l2 != NULL)
            {
                temp += l2 -> val;
                l2 = l2 -> next;
            }
            temp += carry;
            
            p -> next = new ListNode(temp % 10);
            p = p -> next;
            carry = temp / 10;

        }
        return result -> next;
        
    }
};

int main()
{
    ListNode *l1 = new ListNode(0), *l2 = new ListNode(0), *p1 = l1, *p2 = l2;

    int num;
    cout<<"input l1:"<<endl;
    while (cin>>num)
    {
        if (num > 9)
        {
            break;
        }
        p1 -> next = new ListNode(num);
        p1 = p1 -> next;
    }
    cout<<"input l2:"<<endl;
    while (cin>>num)
    {
        if (num > 9)
        {
            break;
        }
        p2 -> next = new ListNode(num);
        p2 = p2 -> next;
    }
    Solution solution;
    ListNode *result = solution.addTwoNumbers(l1 -> next, l2 -> next);
    while(result -> next != NULL)
    {
        cout << result -> val << " -> ";
        result = result -> next;
    }
    cout<< result -> val << endl;
    return 0;
}