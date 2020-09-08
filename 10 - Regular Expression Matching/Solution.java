import java.util.regex.*;

class Solution {
    public boolean isMatch(String s, String p) {
        Pattern pattern = Pattern.compile("^" + p + "$");
        Matcher matcher = pattern.matcher(s);
        
        if (matcher.find()) {
            return true;
        }
        return false;
    }
}