import sys
input = sys.stdin.readline

N,M = list(map(int,input().split()))
board = [list(input().strip()) for _ in range(N)]
visited = [[0 for ii in range(M)]for _ in range(N)]
dxdy =[[1,0],[-1,0],[0,1],[0,-1]]

b_ball = [0,0]
r_ball = [0,0]

for i in range(len(board)):
    if 'R' in board[i]:
        r_ball = [i,board[i].index('R')]
        visited[r_ball[0]][r_ball[1]] = 1
        board[i][r_ball[1]] = '.'
    if 'B' in board[i]:
        b_ball = [i,board[i].index('B')]
        board[i][b_ball[1]] = '.'

que = [[0,r_ball,b_ball]]
results = []
while que:
    cnt, [rx,ry],[bx,by]= que.pop(0)
    if cnt>=10: continue
    for dx,dy in dxdy:
        i = 1
        j = 1

        #빨강 움직임
        board[bx][by] = 'B'
        while board[rx+dx*i][ry+dy*i] not in ['#','B']:
            if board[rx+dx*i][ry+dy*i] == 'O':
                break
            i += 1

        #파랑 움직임
        if board[rx+dx*i][ry+dy*i] != 'O':
            board[rx+dx*(i-1)][ry+dy*(i-1)] = 'R'
        board[bx][by] = '.'
        while board[bx+dx*j][by+dy*j] not in ['#','R']:
            if board[bx+dx*j][by+dy*j] == 'O':
                break
            j +=1
        if board[bx+dx*j][by+dy*j] == 'O': 
            board[rx+dx*(i-1)][ry+dy*(i-1)] = '.'
            continue
        board[rx+dx*(i-1)][ry+dy*(i-1)] = '.'

        j -=1
        board[bx][by] = '.'
        board[bx+dx*j][by+dy*j] = 'B'

        # 파랑과 부딧힌 경우를 대비한 빨강 움직임
        while board[rx+dx*i][ry+dy*i] not in ['#','B']:
            if board[rx+dx*i][ry+dy*i] == 'O':
                break
            i+=1
        if board[rx+dx*i][ry+dy*i] == 'O':
            results.append(cnt+1)
            continue
        i-=1
        board[bx+dx*j][by+dy*j] = '.'
        
        if [rx,ry] != [rx+dx*i,ry+dy*i] or [bx,by] != [bx+dx*j,by+dy*j]:
            if [cnt+1, [rx+dx*i,ry+dy*i],[bx+dx*j,by+dy*j]] not in que:
                # print(i,j,dx,dy)
                # print([rx,ry],'=>',[rx+dx*i,ry+dy*i],[bx,by], '=>',[bx+dx*j,by+dy*j],cnt+1)
                # for m in board:
                #     print(m)
                que.append([cnt+1, [rx+dx*i,ry+dy*i],[bx+dx*j,by+dy*j]])
if results:
    print(min(results))
else: print(-1)