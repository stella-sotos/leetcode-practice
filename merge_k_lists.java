// Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

// Example:

// Input:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// Output: 1->1->2->3->4->4->5->6

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ArrayList<Integer> store = new ArrayList<>();
        for(int i = 0; i<lists.length; i++){
            ListNode ptr = lists[i];
            while(ptr!=null){
               store.add(ptr.val);
                ptr = ptr.next;
            }
        }
        if(store.size()==0) return null;
        Collections.sort(store);
        ListNode ans = new ListNode(0);
        ListNode node = ans;
        for(int i = 0; i<store.size();i++){
            node.val= store.get(i);
            if(i+1<store.size()){
                node.next = new ListNode(0);
                node= node.next;
            }
        }
        return ans;
    }
}