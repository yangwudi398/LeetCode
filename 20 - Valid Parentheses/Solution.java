class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c: s.toCharArray()) {
            if (stack.empty()) {
                stack.push(c);
            } else {
                char ch = stack.peek();
                if ((ch == '(' && c == ')') ||
                    (ch == '[' && c == ']') ||
                    (ch == '{' && c == '}')) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }