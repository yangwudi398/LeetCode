class Solution(object):
    def groupAnagrams(self, strs):
        ans = {}
        for s in strs:
            count = self.getCount(s)
            if tuple(count) in ans:
                ans[tuple(count)].append(s)
            else:
                ans[tuple(count)] = [s]
        return ans.values()
                   
    def getCount(self, s):
        count = [0] * 26
        for c in s:
            count[ord(c) - ord('a')] += 1
        return count