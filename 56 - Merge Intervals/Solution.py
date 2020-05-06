class Solution:
    def merge(self, intervals):
        if len(intervals) == 0:
            return []
        
        intervals.sort(key=lambda x: x[0])
        
        ans = []
        prev = intervals[0]
        i = 1
        
        while i < len(intervals):
            curr = intervals[i]
            if curr[0] > prev[1]:
                ans.append(prev)
                prev = curr
            else:
                prev = [prev[0], max(prev[1], curr[1])]
            i += 1
        ans.append(prev)
                
        return ans