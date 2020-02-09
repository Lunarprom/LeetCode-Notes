/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// TODO: Implement LeetCodeHasPathSum 2
// TODO: Implement this in recursion way
class Solution {
    // Solution 1： 先断开再连上
    // Solution 2: 对于一条链表，从第2个节点到第N个节点，依次逐节点插入到第1个节点(head节点)之后，(N-1)次这样的操作结束之后将第1个节点挪到新表的表尾即可
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        
        ListNode result = null;
        while (head != null) {
            // 先保存剩余的链表
            ListNode temp = head.next;
            // 让现有的头指向最后的头
            head.next = result;
            // 最后的头移动到现在的头
            result = head;
            head = temp;
        }
        
        return result;
    }
}