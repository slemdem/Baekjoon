from collections import defaultdict

def solution(gems):
    min_gems  = int(1e9)
    len_gems = len(gems) 
    n_gems = len(set(gems))
    end = 0
    temp = defaultdict(int)
    for start, gem in enumerate(gems):
        while len(temp) < n_gems and end < len_gems: 
            temp[gems[end]] += 1
            end += 1
        if len(temp) == n_gems:
            if min_gems > end-start:
                min_gems = end-start
                result = [start+1, end]      
        temp[gem] -= 1
        if temp[gem] == 0:
            del(temp[gem])
    return result