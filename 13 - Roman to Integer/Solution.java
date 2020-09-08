class Solution {
    public int romanToInt(String s) {
        int num = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == 'M') {
                num += 1000;
            } else if (c == 'D') {
                num += 500;
            } else if (c == 'C') {
                num += 100;
            } else if (c == 'L') {
                num += 50;
            } else if (c == 'X') {
                num += 10;
            } else if (c == 'V') {
                num += 5;
            } else if (c == 'I') {
                num += 1;
            }
        }
        
        if (s.contains("CD") || s.contains("CM")) {
            num -= 200;
        }
        if (s.contains("XL") || s.contains("XC")) {
            num -= 20;
        }
        if (s.contains("IV") || s.contains("IX")) {
            num -= 2;
        }
        
        return num;
    }
}