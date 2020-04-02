class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0 || k == 0)
            return new int[0];
        
        int n = nums.length;
        Deque<Integer> queue = new LinkedList<>();
        int[] ans = new int[n - k + 1];
        int e = 0;
        
        for (int i = 0; i < n; i++) {
            if (!queue.isEmpty() && queue.peek() <= i - k)
                queue.poll();
            
            while (!queue.isEmpty() && nums[i] > nums[queue.peekLast()])
                queue.pollLast();
            
            queue.offer(i);
            
            if (i >= k - 1)
                ans[e++] = nums[queue.peek()];
        }
        
        return ans;
    }
}