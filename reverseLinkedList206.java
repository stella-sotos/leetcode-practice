/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        return reverseListHelp(head, null);
    }

    public ListNode reverseListHelp(ListNode node, ListNode prev) {
        if (node != null && node.next != null) {
            ListNode nextPrev = node;
            ListNode next = node.next;
            node.next = prev;
            prev = node;
            return reverseListHelp(next, nextPrev);
        } else {
            node.next = prev;
            return node;
        }
    }
}