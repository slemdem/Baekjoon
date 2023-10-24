import sys
from collections import deque

def movable(x, y):
    if x < 0 or x > N-1 or y < 0 or y > M-1 :
        return False
    if arr[x][y] == 1:
        return True
    return False

def find_maze(x,y):
    que = deque([[x,y]])
    cnt = 1
    while que:
        que_size = len(que)
        for i in range(que_size):
            nowx, nowy = que.popleft()
            # 종료조건
            if (nowx, nowy) == (N-1,M-1):
                return cnt
        
            arr[nowx][nowy] = 0

            for i in range(4):
                if movable(nowx+moverange[i][0],nowy+moverange[i][1]):
                    que.append([nowx+moverange[i][0],nowy+moverange[i][1]])
                    arr[nowx+moverange[i][0]][nowy+moverange[i][1]] = 0
                  
        cnt += 1
        
    return cnt
            
N, M = list(map(int, sys.stdin.readline().split()))
arr = [list(map(int, list(sys.stdin.readline().strip()))) for _ in range(N)]

moverange = ((1,0),(0,1),(-1,0),(0,-1))

print(find_maze(0,0))