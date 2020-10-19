class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> output = new ArrayList<>();
        backtrack(output, 0, nums);
        return output;
    }
    
    private void backtrack(List<List<Integer>> output, int first, int[] nums) {
        if (first == nums.length - 1) {
            List<Integer> list = new ArrayList<Integer>();
            for (int n: nums) list.add(n);
            output.add(list);
            return;
        }
        
        for (int i = first; i < nums.length; i++) {
            swap(first, i, nums);
            backtrack(output, first + 1, nums);
            swap(first, i, nums);
        }
    }
    
    private void swap(int i, int j, int[] nums) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}