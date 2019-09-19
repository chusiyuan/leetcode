#include<iostream>
using namespace std;
/*
给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */


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