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
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // Get length of the linked list
        int length = 0;
        ListNode currentNode = dummy;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.next;
        }
        
        // Remove the nth node from the linked list
        int index = length - n;
        currentNode = dummy;
        for (int i = 0; i < index - 1; i++) {
            currentNode = currentNode.next;
        }
        currentNode.next = currentNode.next.next;
        
        return dummy.next;
    }
}