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
        if(head == null || head.next == null) return null;
        int len = 1;
        ListNode ptr = head;
        while(ptr.next!=null){
            len++;
            ptr = ptr.next;
        }
        int pos = len - n;
        ListNode cur; 
        if(pos == 0) {
            cur = new ListNode(head.next.val);
            head = head.next;
        }else {
           cur  = new ListNode(head.val);
        }
        ListNode toReturn = cur;
        int start = 1;
        if(pos <= 0 ) start = pos+1;
        for(int i = start; i<=len;i++){
            if(i == pos){
                head = head.next;
            }else if(head.next != null){
                cur.next = new ListNode(head.next.val);
                cur = cur.next;
                head = head.next;
            }   
        }
        return toReturn;
    }
}