/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Maintain a mini list that's n size and move it to the end.
        if (head == null) {
            return null;
        }
        ListNode tail = head;
        ListNode previous = head;
        // current.next = tail;
        for (int i = 0; i < n; i++) {
            tail = tail.next;
        }
        
        if (tail == null) {
            return head.next;
        } 
        
        while (tail.next != null) {
            tail = tail.next;
            previous = previous.next;
        }

        previous.next = previous.next.next;
        return head;
    }
}