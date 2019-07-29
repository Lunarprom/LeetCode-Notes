/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 1->2->3->4->5->NULL
// tmp = 2->3->4->5->NULL
// 1->NULL
// prev = 1
// head = 2->3->4->5->NULL
// temp = 3->4->5->NULL
// head: 2->1->NULL
// prev = 2
// head = 3
// 每次都把当前的头指向上次的头（也就是反过来了。因为链表本来是当前的头指向下一次的头）
class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while(head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }

        return prev;
    }
}