class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        
        String minStr = strs[0];
        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            if (str.length() < minStr.length()) {
                minStr = str;
            }
        }
        
        String commonPrefix = "";
        int left = 0;
        int right = minStr.length() - 1; 
        
        while (left <= right) {
            int mid = (right + left) / 2;
            
            if (isCommonPrefix(strs, mid + 1)) {
                commonPrefix += minStr.substring(left, mid + 1);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return commonPrefix;
    }
    
    private boolean isCommonPrefix(String[] strs, int len) {
        String prefix = strs[0].substring(0, len);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(prefix)) {
                return false;
            }
        }
        return true;
    }
}