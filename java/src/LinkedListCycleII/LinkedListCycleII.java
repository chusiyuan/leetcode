package LinkedListCycleII;
/*
给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
说明：不允许修改给定的链表。
进阶：
你是否可以不用额外空间解决此题？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/linked-list-cycle-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
* */

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast =head;
        while(fast != null){
            if (fast.next == null || fast.next.next == null){
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast){
                break;
            }
        }
        fast = head;
        while(slow != fast){
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args){
        LinkedListCycleII sln = new LinkedListCycleII();
        ListNode head = new ListNode(0);
        ListNode node = head;
        for (int i = 1; i < 5; i++){
            node.next = new ListNode(i);
            node = node.next;
        }
        node.next = head;
        System.out.println(sln.detectCycle(head));
    }
}
