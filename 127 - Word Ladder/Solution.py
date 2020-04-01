class Solution(object):
    def ladderLength(self, beginWord, endWord, wordList):
        transforms = defaultdict(list)
        for word in wordList:
            for i in range(len(word)):
                trans = word[:i] + '*' + word[i+1:]
                transforms[trans].append(word)
        
        step = 0
        queue = [beginWord]
        visited = {beginWord}
        
        while len(queue) > 0:
            step += 1
            size = len(queue)
            for _ in range(size):
                word = queue.pop(0)
                print(word)
                for i in range(len(word)):
                    trans = word[:i] + '*' + word[i+1:]
                    for w in transforms[trans]:
                        if w == endWord:
                            return step + 1
                        if w not in visited:
                            queue.append(w)
                            visited.add(w)
                            
        return 0
            