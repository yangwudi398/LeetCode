class Solution {
    public String addBinary(String a, String b) {
        boolean carry = false;
        StringBuilder sum = new StringBuilder();
        
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        
        for (int i = 1; i <= b.length(); i++) {
            char digitA = a.charAt(a.length() - i);
            char digitB = b.charAt(b.length() - i);
            char digit = '1';
            boolean nextCarry = false;
                
            if (digitA == '0' && digitB == '0') {
                digit = '0';
            } else if (digitA == '1' && digitB == '1') {
                digit = '0';
                nextCarry = true;
            }
                
            if (carry) {
                if (digit == '0') {
                    digit = '1';
                } else {
                   digit = '0';
                    nextCarry = true;
                }
            } 
            
            
            sum = sum.append(digit);
            carry = nextCarry;
        }
                
        for (int i = a.length() - b.length() - 1; i >= 0; i--) {
            char digit = a.charAt(i);
            
            if (carry) {
                if (digit == '0') {
                    digit = '1';
                    carry = false;
                } else {
                    digit = '0';
                }
            }
            
            sum.append(digit);
        }
        
        if (carry) {
            sum.append('1');
        }
        
        
        return sum.reverse().toString();
    }
}