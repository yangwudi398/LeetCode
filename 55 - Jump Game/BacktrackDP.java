class Solution {    
    public boolean canJump(int[] nums) {
        boolean[] invalid = new boolean[nums.length];
        return reachEnd(nums, invalid, 0);
    }
    
    private boolean reachEnd(int[] nums, boolean[] invalid, int step) {
        if (invalid[step])
            return false;
        if (step > nums.length - 1) 
            return false;
        if (step == nums.length - 1)
            return true;
        
        for (int i = 1; i <= nums[step]; i++) {
            if (reachEnd(nums, invalid, step + i)) {
                return true;
            }
        }
        
        invalid[step] = true;
        return false;
    }
}