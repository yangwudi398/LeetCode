import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>(24);
        int maxLength = 0;
        int currLength = 0;
        int currStart = 0;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (map.containsKey(c)) {
                int index = map.get(c);
                if (index < currStart) {
                    currLength += 1;
                } else {
                    currLength = i - index;
                    currStart = index + 1;
                }
                map.put(c, i);
            } else {
                currLength += 1;
                map.put(c, i);
            }
            
            if (currLength > maxLength) {
                maxLength = currLength;
            }
        }
        
        return maxLength;
    }
}