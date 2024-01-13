import sys
input = sys.stdin.readline

def is_valid(x,y):
    if(x<0 or x>=N or y<0 or y>=N): return False
    if(visited[x][y] == 1 or visited[x][y] == 2): return False
    
    return AREA[x][y]

def is_valid_weak(x,y):
    if(x<0 or x>=N or y<0 or y>=N): return False
    if(visited[x][y] != 2): return False
    
    return AREA[x][y]

N = int(input())
AREA = []
for i in range(N):
    AREA.append(list(input()))

visited = [[0 for i in range(N)] for _ in range(N)]

que = []
queWeak = []
count = 0
weakcount = 0
for i in range(N):
    for j in range(N):
        if(visited[i][j] == 0):
            color_now = AREA[i][j]
            que.append([i,j])
        else:
            continue
        if(color_now == 'R' or color_now == 'G'):
            visited[i][j] = 2
            while que:
                x_now, y_now = que.pop()
                if(is_valid(x_now+1, y_now) == 'R' or is_valid(x_now+1, y_now) == 'G'):
                    visited[x_now+1][y_now] = 2
                    que.append([x_now+1,y_now])
                if(is_valid(x_now, y_now+1) == 'R' or is_valid(x_now, y_now+1) == 'G'):
                    visited[x_now][y_now+1] = 2
                    que.append([x_now,y_now+1])
                if(is_valid(x_now-1, y_now) == 'R' or is_valid(x_now-1, y_now) == 'G'):
                    visited[x_now-1][y_now] = 2
                    que.append([x_now-1,y_now])
                if(is_valid(x_now, y_now-1) == 'R' or is_valid(x_now, y_now-1) == 'G'):
                    visited[x_now][y_now-1] = 2
                    que.append([x_now,y_now-1])
            for l in range(N):
                for z in range(N):
                    if(visited[l][z] == 2):
                        visited[l][z] = 1
                        color_now = AREA[l][z]
                        queWeak.append([l,z])
                    else:
                        continue
                    while queWeak:
                        x_now, y_now = queWeak.pop()
                        if(is_valid_weak(x_now+1, y_now) == color_now):
                            visited[x_now+1][y_now] = 1
                            queWeak.append([x_now+1,y_now])
                        if(is_valid_weak(x_now, y_now+1) == color_now):
                            visited[x_now][y_now+1] = 1
                            queWeak.append([x_now,y_now+1])
                        if(is_valid_weak(x_now-1, y_now) == color_now):
                            visited[x_now-1][y_now] = 1
                            queWeak.append([x_now-1,y_now])
                        if(is_valid_weak(x_now, y_now-1) == color_now):
                            visited[x_now][y_now-1] = 1
                            queWeak.append([x_now,y_now-1])
                    count +=1
        else:
            visited[i][j] = 1
            while que:
                x_now, y_now = que.pop()
                if(is_valid(x_now+1, y_now) == color_now):
                    visited[x_now+1][y_now] = 1
                    que.append([x_now+1,y_now])
                if(is_valid(x_now, y_now+1) == color_now):
                    visited[x_now][y_now+1] = 1
                    que.append([x_now,y_now+1])
                if(is_valid(x_now-1, y_now) == color_now):
                    visited[x_now-1][y_now] = 1
                    que.append([x_now-1,y_now])
                if(is_valid(x_now, y_now-1) == color_now):
                    visited[x_now][y_now-1] = 1
                    que.append([x_now,y_now-1])
            count +=1
        weakcount +=1
print(count, weakcount)