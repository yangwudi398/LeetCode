class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans = new ArrayList<>();
        BFS(s, 0, 0, "", ans);
        return ans;
    }
    
    private void BFS(String s, int index, int n, String curr, List<String> ans) {
        if (n < 3) {
            for (int len = 1; len <= 3; len++) {
                if (index + len >= s.length()) { // no place for 4th digit
                    break;
                }
                String digits = s.substring(index, index + len);
                if (isValid(digits)) {
                    BFS(s, index + len, n + 1, curr + digits + ".", ans);
                }
            }
        } else {
            String digits = s.substring(index);
            if (isValid(digits)) {
                ans.add(curr + digits);
            } 
        }
    }
    
    private boolean isValid(String digits) {
        if (digits.length() > 3)
            return false;
        if (digits.length() > 1 && digits.charAt(0) == '0')
            return false;
        int num = Integer.parseInt(digits);
        return num >= 0 && num <= 255;
    }
}