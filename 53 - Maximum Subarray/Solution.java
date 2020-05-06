class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0)
            return 0;
        
        int currSum = 0;
        int maxSum = nums[0];
        
        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            
            if (maxSum < currSum)
                maxSum = currSum; 
            
            if (currSum < 0) 
                currSum = 0;
        }
        
        return maxSum;
    }
}