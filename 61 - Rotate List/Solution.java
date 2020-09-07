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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return head;
        
        int count = 0;
        
        ListNode curr = head;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        
        k = k % count;
        
        curr = head;
        for (int i = 0; i < count - k - 1; i++) 
            curr = curr.next;
        
        ListNode currHead = head;
        if (curr.next == null)
            return head;
        head = curr.next;
        curr.next = null;
        
        curr = head;
        for (int i = 0; i < k - 1; i++) 
            curr = curr.next;
        curr.next = currHead;
        
        return head;
    }
}