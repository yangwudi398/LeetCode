/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curNode = dummy;
        
        while (curNode.next != null) {
            ListNode firstNode = curNode.next;
            ListNode secondNode = firstNode.next;
            
            if (secondNode != null) {
                firstNode.next = secondNode.next;
                secondNode.next = firstNode;
                curNode.next = secondNode;
            } 
            curNode = firstNode;
        }
        
        return dummy.next;
    }
}