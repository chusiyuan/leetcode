//给定一个链表，判断链表中是否有环。
//
//        进阶：
//        你能用 O(1)（即，常量）内存解决此问题吗？
//
//        来源：力扣（LeetCode）
//        链接：https://leetcode-cn.com/problems/linked-list-cycle
//        著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
