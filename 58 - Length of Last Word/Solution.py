class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        words = s.rstrip().split(' ')
        return 0 if len(words) == 0 else len(words[len(words)-1])