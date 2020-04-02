class Solution(object):
    def subsets(self, nums):
        ans = []
        
        def backtrack(curr, first, subLen):            
            if len(curr) == subLen:
                ans.append(curr[:])
            else:
                for i in range(first, len(nums)):
                    curr.append(nums[i])
                    backtrack(curr, i + 1, subLen)
                    curr.pop()
        
        for subLen in range(0, len(nums) + 1):
            backtrack([], 0, subLen)
            
        return ans
            