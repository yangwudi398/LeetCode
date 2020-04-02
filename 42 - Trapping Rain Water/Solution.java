class Solution {
    public int trap(int[] height) {
        int water = 0;
        Stack<Integer> stack = new Stack<>();
        
        for (int i = 0; i < height.length; i++) {
            while (!stack.empty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.empty()) break;
                
                int previous = stack.peek();
                int distance = i - previous - 1;
                int heightDiff = Math.min(height[i] - height[top], height[previous] - height[top]);
                water += distance * heightDiff;
            }
            stack.push(i);
        }
        
        return water;
    }
}