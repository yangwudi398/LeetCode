class Solution {
    public boolean canJump(int[] nums) {
        int position = nums.length - 1;
        
        for (int step = nums.length - 1; step >= 0; step--) {
            if (step + nums[step] >= position) {
                position = step;
            }
        }
        
        return position == 0;
    }
}