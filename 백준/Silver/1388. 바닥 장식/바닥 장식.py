import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000)

from collections import deque

def wrongvalue(x,y):
    if x < 0 or x > N-1 or y < 0 or y > M-1 :
        return True
    if visited[x][y] == 0:
        return False
    return True

def BFS(x,y,value):
    global count
    visited[x][y] = 1
    queue = deque([[x, y, value]])
    
    while queue:
        nowx, nowy, last = queue.popleft()
        if floor[nowx][nowy] == last:
            visited[nowx][nowy] = 1
            if last == '-':
                if not wrongvalue(nowx,nowy+1):
                    queue.append([nowx,nowy+1,'-'])
            if last == '|':
                if not wrongvalue(nowx+1,nowy):
                    queue.append([nowx+1,nowy,'|'])
        else:
            return

            

N, M = list(map(int, input().split()))
floor = [[] for i in range(N)]

for i in range(N):
    floor[i] = list(sys.stdin.readline().strip())
    
visited = [[0 for i in range(M)] for j in range(N)]
count = 0
last = '.'
for i in range(N):
    for j in range(M):
        if visited[i][j] == 0:
            count+=1
            BFS(i,j,floor[i][j])
                
print(count)