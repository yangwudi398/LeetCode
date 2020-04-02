/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) return null;
        
        ListNode dummy = new ListNode(0);
        ListNode curNode = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                curNode.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                curNode.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            curNode = curNode.next;
        }
        
        if (l1 == null)
            curNode.next = l2;
        if (l2 == null)
            curNode.next = l1;
        
        return dummy.next;
    }
}