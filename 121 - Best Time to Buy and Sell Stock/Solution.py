class Solution(object):
    def maxProfit(self, prices):
        if len(prices) < 2:
            return 0
        
        min_price = prices[0]
        max_profit = 0
        
        for p in prices:
            if p < min_price:
                min_price = p
            elif p - min_price > max_profit:
                max_profit = p - min_price
        
        return max_profit