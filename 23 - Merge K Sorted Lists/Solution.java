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
        ListNode dummy = new ListNode(0);
        
        Deque<ListNode> queue = new LinkedList<>();
        for (ListNode list: lists)
            queue.offer(list);
        
        while (queue.size() > 1) {
            ListNode list1 = queue.poll();
            ListNode list2 = queue.poll();
            queue.offer(merge2List(list1, list2));
        }
        
        return queue.poll();
    }
    
    public ListNode merge2List(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode curNode = dummy;
        
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                curNode.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                curNode.next = new ListNode(list2.val);
                list2 = list2.next;
            }
            curNode = curNode.next;
        }
        
        if (list1 == null) 
            curNode.next = list2;
        if (list2 == null)
            curNode.next = list1;
        
        return dummy.next;
    }
}