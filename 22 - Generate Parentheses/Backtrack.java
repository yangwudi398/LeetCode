class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        backTrack(ans, "", 0, 0, n);
        return ans;
    }
    
    public void backTrack(List<String> ans, String str, int numOpen, int numClose, int max) {
        if (str.length() == max * 2) {
            ans.add(str);
        } else {
            if (numOpen < max) {
                backTrack(ans, str + "(", numOpen + 1, numClose, max);
            } 
            if (numClose < numOpen) {
                backTrack(ans, str + ")", numOpen, numClose + 1, max);
            }
        }
    }
}