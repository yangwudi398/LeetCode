class Solution {
    public int strStr(String haystack, String needle) {        
        int subLen = needle.length();
        for (int i = 0; i <= haystack.length() - subLen; i++) {
            if (haystack.substring(i, i + subLen).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}