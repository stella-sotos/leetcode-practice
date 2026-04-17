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
    public int pairSum(ListNode head) {
        ListNode ptr1 = head;
        ListNode ptr2 = head;
        List<Integer> vals = new ArrayList<>();
        int s = 0;
        while (ptr2 != null && ptr2.next != null) {
            vals.add(s, ptr1.val);
            ptr1 = ptr1.next;
            ptr2 = ptr2.next.next;
            s++;
        }
        // the result of this is ptr1 to the middle of the list and we know the size (2* s)
        int length = s * 2;
        int max = 0 - Integer.MAX_VALUE;
        // now we use that ptr1 to finish the sum calculations
        for (int i = s; i < length; i++) {
            int twin = length - i - 1;
            int twinSum = vals.get(twin) + ptr1.val;
            if (twinSum > max) {
                max = twinSum;
            }
            ptr1 = ptr1.next;
        }
        return max;

    }
}