import sys
from collections import deque 
input = sys.stdin.readline

def dofunc(a) :
    que = deque()
    que.append([[arr[a]],[a]])
    
    while(que):
        poped, visited = que.popleft()
        for i in range(N):
            if(i in visited): continue
            
            now = poped + [arr[i]]
            visit = visited + [i]
            
            if (len(now)>M):
                continue
            if(len(now)==M):
                results.add(tuple(now))
            else:
                que.append([now,visit])
                
N,M = map(int,input().split())
arr = list(map(int,input().split()))

arr.sort()

results = set()
if M < 2:
    results.update(set(arr))
for i in range(N):
    dofunc(i)

for i in results:
    if (type(i)==int):
        print(i)
    else:
        print(*i)
