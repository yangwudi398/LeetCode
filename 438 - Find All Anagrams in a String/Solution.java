class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int lenS = s.length();
        int lenP = p.length();
        
        if (lenS == 0 || lenP == 0)
            return new ArrayList<>(0);
        
        List<Integer> ans = new ArrayList<>();
        
        int[] charP = new int[26];
        for (char c: p.toCharArray())
            charP[c - 'a'] += 1;
        
        int[] charS = new int[26];
        
        for (int i = 0; i < lenS; i++) {
            char c = s.charAt(i);
            charS[c - 'a'] += 1;
            
            if (i >= lenP - 1) {
                if (isAnagram(charS, charP))
                    ans.add(i - lenP + 1);
                charS[s.charAt(i - lenP + 1) - 'a'] -= 1;
            }
        }
        
        return ans;
    }
    
    private boolean isAnagram(int[] charS, int[] charP) {
        for (int i = 0; i < 26; i++)
            if (charS[i] != charP[i])
                return false;
        return true;
    }
}