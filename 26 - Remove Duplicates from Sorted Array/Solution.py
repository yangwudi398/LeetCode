class Solution(object):
    def removeDuplicates(self, nums):
        if len(nums) == 0:
            return 0;
        
        last = nums[0]
        idx = 1
        while idx < len(nums):
            if nums[idx] == last:
                nums.pop(idx)
            else:
                last = nums[idx]
                idx += 1
                
        return len(nums)