import sys
input = sys.stdin.readline
sys.setrecursionlimit(10000)

import sys
from collections import deque

def movable(x, y):
    if x < 0 or x > N-1 or y < 0 or y > N-1 :
        return False
    if arr[x][y] == 0 :
        return True
    return False


def spread(s):
    que = deque(virous)
    
    while que:
        if s <= 0:
            return
        
        que_size = len(que)
        for i in range(que_size):
            vnum, nowx, nowy = que.popleft()
            for i in range(4):
                if movable(nowx+moverange[i][0],nowy+moverange[i][1]):
                    que.append([vnum,nowx+moverange[i][0],nowy+moverange[i][1]])
                    arr[nowx+moverange[i][0]][nowy+moverange[i][1]] = vnum
        
        s -= 1
            
N, K = list(map(int, sys.stdin.readline().split()))
arr = [[] for _ in range(N)]
virous = []
for i in range(N):
    arr[i] = list(map(int,sys.stdin.readline().split()))
    for j in range(N):
        if arr[i][j] != 0:
            virous.append([arr[i][j],i,j])
        
moverange = ((1,0),(0,1),(-1,0),(0,-1))
virous.sort()
time, positionx, positiony = list(map(int, sys.stdin.readline().split()))

spread(time)

print(arr[positionx-1][positiony-1])