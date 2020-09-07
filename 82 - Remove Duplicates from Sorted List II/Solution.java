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
    public ListNode deleteDuplicates(ListNode head) {
        boolean duplicate = false;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode currNode = head;
        ListNode prevNode = dummy;
        
        while (currNode != null) {
            if (currNode.next != null && currNode.val == currNode.next.val) {
                currNode.next = currNode.next.next;
                duplicate = true;
            } else {
                if (duplicate) { // remove duplicated number
                    prevNode.next = currNode.next;
                    currNode = prevNode.next;
                    duplicate = false;
                } else { // pass on
                    prevNode = currNode;
                    currNode = currNode.next;
                }
            }
        }
        
        return dummy.next;
    }
}