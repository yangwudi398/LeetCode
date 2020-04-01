/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        int carry = 0;
        ListNode curr = dummyHead;
        
        while(l1 != null || l2 != null) {
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;
            int sum = carry + v1 + v2;
            
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            curr = curr.next;
        }
        
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        
        return dummyHead.next;
    }
}