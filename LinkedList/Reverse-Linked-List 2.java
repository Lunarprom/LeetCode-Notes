/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// dummy->1->2->3->4->5->NULL
// dummy->2->1->2  3->4->5->NULL (1实际还指向2)
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = head.next;
        
        while (current != null) {
            ListNode temp = current.next;
            current.next = dummy.next;
            dummy.next = current;
            current = temp;
        }
        head.next = null;
        return dummy.next;
    }
}