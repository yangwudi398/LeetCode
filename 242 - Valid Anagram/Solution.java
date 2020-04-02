class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        
        int[] chars1 = new int[26];
        for (char c: s.toCharArray())
            chars1[c - 'a'] += 1;
        
        int[] chars2 = new int[26];
        for (char c: t.toCharArray())
            chars2[c - 'a'] += 1;
        
        for (int i = 0; i < chars1.length; i++)
            if (chars1[i] != chars2[i])
                return false;
        return true;
    }
}