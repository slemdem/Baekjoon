import sys
input = sys.stdin.readline
from collections import deque


def not_ripe(x, y, level):
    if x < 0 or x > M*H-1 or y < 0 or y > N-1 :
        return False
    if x < (level*M) or x >= (level+1)*M:
        return False
    
    if arr[x][y] == 0:
        return True
    return False

def make_ripe(riped):
    que = deque(riped)
    cnt = 0
    while que:
        que_size = len(que)
        for i in range(que_size):
            nowx, nowy, level = que.popleft()
            for i in range(6):
                if not_ripe(nowx+moverange[i][0],nowy+moverange[i][1],level+moverange[i][2]):
                    que.append([nowx+moverange[i][0],nowy+moverange[i][1],level+moverange[i][2]])
                    arr[nowx+moverange[i][0]][nowy+moverange[i][1]] = 1
                  
        cnt += 1
    return cnt -1
            
N, M, H = list(map(int, sys.stdin.readline().split()))

allriped = True
riped = []
arr = [[] for _ in range(M*H)]
for i in range(M*H):
    arr[i] = list(map(int,input().split()))
    for j in range(N):
        if arr[i][j] == 1:
            riped.append([i,j,i//M])
        if arr[i][j] == 0:
            allriped = False
            
if allriped == True:
    print(0)
    exit()
    
moverange = ((1, 0, 0),(0,1, 0),(-1,0, 0),(0,-1, 0),(M,0, 1),(-M,0, -1))
count = make_ripe(riped)

allriped = True
for i in range(M*H):
    for j in range(N):
        if arr[i][j] == 0:
            allriped = False

if allriped == True:
    print(count)
else:
    print(-1)