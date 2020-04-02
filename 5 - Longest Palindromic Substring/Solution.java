class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        
        int longestLeft = 0;
        int longestRight = 0;
        for (int i = 0; i < s.length(); i++) {
            int oddPalindromeLength = getPalindromeLength(s, i, i);
            int eventPalindromeLength = getPalindromeLength(s, i, i + 1);
            int palindromeLength = Math.max(oddPalindromeLength, eventPalindromeLength);
            if (palindromeLength > longestRight - longestLeft + 1) {
                longestLeft = i - (palindromeLength - 1) / 2;
                longestRight = i + palindromeLength / 2;
            }
        }
        
        return s.substring(longestLeft, longestRight + 1);
    }
    
    private int getPalindromeLength(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--; right++;
        }
        return right - left - 1;
    }
}