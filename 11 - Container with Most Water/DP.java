class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        
        while (left < right) {
            int heightLeft = height[left];
            int heightRight = height[right];
            int area = 0;
            
            if (heightLeft < heightRight) {
                area = heightLeft * (right - left);
                left++;
            } else {
                area = heightRight * (right - left);
                right--;
            }
            
            if (area > maxArea) {
                maxArea = area;
            }
        }
        
        return maxArea;
    }
}