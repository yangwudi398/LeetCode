class Solution:
    def insert_I(self, intervals, newInterval):
        i = 0
        while i < len(intervals):
            interval = intervals[i]
            
            # behind but not overlapping, pass on
            if newInterval[0] > interval[1]:
                i += 1
            # ahead but not overlapping, insert and return
            elif newInterval[1] < interval[0]:
                intervals.insert(i, newInterval)
                return intervals
            # overlapping, replace it with suitable range
            else:
                newInterval = [min(interval[0], newInterval[0]), max(interval[1], newInterval[1])]
                del intervals[i]
        
        # if not already returned, append new interval and return
        intervals.append(newInterval)
        return intervals

    def insert_II(self, intervals, newInterval):
        ans = []
        
        for i in range(len(intervals)):
            interval = intervals[i]
            
            # behind but not overlapping, pass on
            if newInterval[0] > interval[1]:
                ans.append(interval)
            # ahead but not overlapping, insert and return
            elif newInterval[1] < interval[0]:
                ans.append(newInterval)
                return ans + [interval for interval in intervals[i:]]
            # overlapping, replace it with suitable range
            else:
                newInterval = [min(interval[0], newInterval[0]), max(interval[1], newInterval[1])]
        
        # if not already returned, append new interval and return 
        ans.append(newInterval)
        return ans