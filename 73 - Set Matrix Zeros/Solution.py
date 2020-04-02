class Solution(object):
    def setZeroes(self, matrix):
        """
        :type matrix: List[List[int]]
        :rtype: None Do not return anything, modify matrix in-place instead.
        """
        nRow = len(matrix)
        nCol = len(matrix[0])
        arr = []
        for i in range(nRow):
            for j in range(nCol):
                if matrix[i][j] == 0:
                    arr.append((i, j))
        for ij in arr:
            i, j = ij
            for r in range(nRow):
                matrix[r][j] = 0
            for c in range(nCol):
                matrix[i][c] = 0