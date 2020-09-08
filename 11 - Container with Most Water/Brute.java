class Solution {
    public int maxArea(int[] height) {
        int maxHeight = 0;
        int maxWidth = 0;
        
        for (int i = 0; i < height.length; i++) {
            int h1 = height[i];
            int maxW = 0;
            
            for (int j = 0; j < height.length; j++) {
                int h2 = height[j];
                if (h2 >= h1 && Math.abs(j - i) > maxW) {
                    maxW = Math.abs(j - i);
                }
            }
            
            System.out.println(maxW);
            
            if (h1 * maxW > maxHeight * maxWidth) {
                maxHeight = h1;
                maxWidth = maxW;
            }
        }
        
        return maxHeight * maxWidth;
    }
}