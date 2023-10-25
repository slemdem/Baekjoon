import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**8)
from collections import deque

def movable(x, y):
    if x < 0 or x > N-1 or y < 0 or y > M-1 :
        return False
    if arr[x][y] == '.' or arr[x][y] == 'D':
        return True
    return False

def waterwave(x,y):
    if x < 0 or x > N-1 or y < 0 or y > M-1 :
        return False
    if arr[x][y] == 'X' or arr[x][y] == 'D' or arr[x][y] == '*':
        return False
    return True

def find_maze(S,E):
    queS = deque([S])
    queHazard = deque(hazard)
    cnt = 0
    while queS:
        que_size = len(queHazard)
        for i in range(que_size):
            nowx, nowy = queHazard.popleft()
        
            arr[nowx][nowy] = '*'

            for i in range(4):
                if waterwave(nowx+moverange[i][0],nowy+moverange[i][1]):
                    queHazard.append([nowx+moverange[i][0],nowy+moverange[i][1]])
                    arr[nowx+moverange[i][0]][nowy+moverange[i][1]] = '*'
        que_size = len(queS)
        
        for i in range(que_size):
            nowx, nowy = queS.popleft()
            # 종료조건
            if [nowx,nowy] == E:
                return cnt
        
            arr[nowx][nowy] = '0'

            for i in range(4):
                if movable(nowx+moverange[i][0],nowy+moverange[i][1]):
                    queS.append([nowx+moverange[i][0],nowy+moverange[i][1]])
                    arr[nowx+moverange[i][0]][nowy+moverange[i][1]] = '0'
                  
        
        cnt += 1
        
    return 'KAKTUS'
            
N, M = list(map(int, sys.stdin.readline().split()))
arr = [[] for _ in range(N)]
start =[]
end = []
hazard = []
for i in range(N):
    row = sys.stdin.readline()
    for j in range(M):
        arr[i].append(row[j])
        if row[j] == '*':
            hazard.append([i, j])
        if row[j] == 'D':
            end = [i, j]
        if row[j] == 'S':
            start = [i, j]
        
moverange = ((1,0),(0,1),(-1,0),(0,-1))

print(find_maze(start,end))