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
    public void reorderList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode curr = head;
        while (curr != null) {
            stack.push(curr);
            curr = curr.next;
        }
        curr = head;

        while (!stack.isEmpty()) {
            ListNode tail = stack.pop();
            
            if (curr == tail || curr.next == tail) {
                tail.next = null;
                break;
            } else {
                tail.next = curr.next;
                curr.next = tail;
                curr = tail.next;
            }
        }
    }
}