import sys
from collections import deque
input = sys.stdin.readline

N = int(input())
arr = []
for i in range(N):
    arr.append(list(map(int, input().strip())))
visited = [[0 for _ in range(N)] for __ in range(N)]
answer = []
dxdy = [[1,0],[-1,0],[0,1],[0,-1]]

for i in range(N):
    for j in range(N):
        if arr[i][j] != 0 and visited[i][j] == 0:
            answer.append(1)
            index = len(answer)
            visited[i][j] = 1
            deq = deque([[i,j]])
            while deq:
                x, y = deq.popleft()
                for dx,dy in dxdy:
                    if 0<= x+dx <N and 0 <= y+dy < N and arr[x+dx][y+dy] != 0 and visited[x+dx][y+dy] == 0:
                        visited[x+dx][y+dy] = 1
                        deq.append([x+dx,y+dy])
                        answer[index-1]+=1
print(len(answer))
answer.sort()
for i in answer:
    print(i)