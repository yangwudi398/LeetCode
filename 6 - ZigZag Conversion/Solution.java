class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1) return s;
        
        String zigzag = "";
        
        for (int i = 0; i < numRows; i++) {
            int idx = i;
            
            while (idx < s.length()) {
                zigzag += s.charAt(idx);
                
                int linkLen = numRows - 2;
                if (i > 0 && i < numRows - 1) {
                    int linkIndex = idx + numRows + linkLen - (i * 2);
                    if (linkIndex < s.length()) {
                        zigzag += s.charAt(linkIndex);
                    }
                }
                    
                idx += numRows + linkLen;
            }
        }
        
        return zigzag;   
    }
}