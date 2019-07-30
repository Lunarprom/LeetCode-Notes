/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m >= n) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode previous = dummy;
        
        for (int i = 0; i < m - 1; i++) {
            if (previous.next == null) {
                return null;
            }
            previous = previous.next;
        }
        // 此时previous指向第m - 1个结点
        // tail指向第m个结点，也就是最终的尾巴
        ListNode tail = previous.next;
        // 翻转从第m+1个结点开始，做m-n次
        ListNode current = tail.next;
        for (int i = 0; i < n - m; i++) {
            // 暂时把current从tail的链条里拿出来（且清干净tail.next
            tail.next = current.next;
            current.next = previous.next;
            previous.next = current;
            current = tail.next;
        }
        
        return dummy.next;
    }
}