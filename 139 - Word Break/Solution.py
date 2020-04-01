class Solution(object):
    def wordBreak(self, s, wordDict):
        lst = [False] * len(s)
        
        for i in range(len(s)):
            for w in wordDict:
                if s[i-len(w)+1:i+1] == w and (i-len(w) == -1 or lst[i-len(w)]):
                    lst[i] = True
        
        return lst[-1]