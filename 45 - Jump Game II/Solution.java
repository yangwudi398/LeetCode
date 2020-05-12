class Solution {
    public int jump(int[] nums) {        
        int currFurthest = 0, currEnd = 0, numJumps = 0;
        
        for (int i = 0; i < nums.length - 1; i++) {
            currFurthest = Math.max(i + nums[i], currFurthest);
            
            if (i == currEnd) {
                numJumps++;
                currEnd = currFurthest;
            }
            
            if (currEnd >= nums.length - 1) {
                return numJumps;
            }
        }
        
        return numJumps;
    }
}