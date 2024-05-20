from collections import deque 

def solution(priorities, location):
    cnt = 0
    locationval = priorities[location]
    priorities = deque(priorities)
    locationque = [0 for _ in range(len(priorities))]
    locationque[location] = 1
    
    while priorities:
        m = max(priorities)
        for i in range(len(priorities)):
            j = priorities.popleft()
            if j == m:
                if locationque[0] == 1:
                    return cnt+1
                del locationque[0]
                break
            else:
                priorities.append(j)
                locationque.append(locationque[0])
                del locationque[0]
        cnt+=1
        