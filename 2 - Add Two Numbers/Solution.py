# Definition for singly-linked list.
# class ListNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.next = None

class Solution(object):
    def addTwoNumbers(self, l1, l2):
        n1 = 0
        mul = 1
        while l1 is not None:
            n1 += l1.val * mul
            mul *= 10
            l1 = l1.next
        
        n2 = 0
        mul = 1
        while l2 is not None:
            n2 += l2.val * mul
            mul *= 10
            l2 = l2.next
        
        s = n1 + n2
        
        head = ListNode(s % 10)
        s /= 10
        
        curr = head
        while s > 0:
            curr.next = ListNode(s % 10)
            s /= 10
            curr = curr.next
            
        return head