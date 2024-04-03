def solution(board):
    costBoard = [[0 for _ in range(len(board))]for _ in range(len(board))]
    delta = [(1,0),(-1,0),(0,1),(0,-1)]
    que = [[0,0,0,-1,0],[0,0,0,0,-1]]
    while que:
        x,y,cost,preX,preY = que.pop()
        for a,b in delta:
            nowX = x + a
            nowY = y + b

            if  0 <= nowX < len(board) and 0 <= nowY < len(board):
                straight = False
                if nowX-x==x-preX and nowY-y == y-preY:
                    nowCost = cost + 100
                    straight = True
                else:
                    nowCost = cost + 600
                if board[nowX][nowY] == 0:
                    if costBoard[nowX][nowY] == 0 or costBoard[nowX][nowY] >= nowCost:
                        costBoard[nowX][nowY] = nowCost
                        que.append([nowX,nowY,nowCost,x,y])
                    elif straight == True and costBoard[nowX][nowY] > nowCost - 500:
                        que.append([nowX,nowY,nowCost,x,y])
                    
    answer = costBoard[-1][-1]
    return answer