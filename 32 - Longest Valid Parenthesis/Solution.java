import java.util.*;

class Solution {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        Set<Integer> valid = new HashSet<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(')
                stack.push(i);
            else {
                if (s.charAt(stack.peek()) == '(') {
                    valid.add(stack.pop());
                    valid.add(i);
                } else 
                    stack.push(i);
            }
        }
         
        int maxLen = 0, currLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (valid.contains(i)) 
                currLen += 1;
            else
                currLen = 0;
            
            if (currLen > maxLen)
                maxLen = currLen; 
        }
        
        return maxLen;
    }
}