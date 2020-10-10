class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] ans = new int[nums.length];
        
        ans[0] = 1;
        for (int i = 1; i < nums.length; i++)
            ans[i] = nums[i-1] * ans[i-1];
        
        int rightProd = 1;
        for (int i = ans.length - 2; i >= 0; i--) {
            rightProd *= nums[i+1];
            ans[i] *= rightProd;
        }
        
        return ans;
    }
}