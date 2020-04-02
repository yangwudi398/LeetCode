class Solution(object):
    def numIslands(self, grid):
        nrow = len(grid)
        if nrow == 0:
            return 0
        ncol = len(grid[0])
        if ncol == 0:
            return 0
        visited = [[False for _ in range(ncol)] for _ in range(nrow)]
        
        def searchIsland(i, j):
            if i < 0 or j < 0 or i >= nrow or j >= ncol or \
            visited[i][j] or grid[i][j] == '0': return
            visited[i][j] = True
            searchIsland(i - 1, j)
            searchIsland(i + 1, j)
            searchIsland(i, j - 1)
            searchIsland(i, j + 1)
        
        count = 0
        for i in range(nrow):
            for j in range(ncol):
                if not visited[i][j] and grid[i][j] == '1':
                    count += 1
                    searchIsland(i, j)
        return count
                    