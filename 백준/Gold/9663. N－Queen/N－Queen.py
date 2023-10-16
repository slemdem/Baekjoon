N = int(input())
board = [0]*15
count = 0

def check_position(n):
    for i in range(n):
        if board[n] == board[i]:
            return False
        if n -i == abs(board[i] - board[n]):
            return False
    return True

def set_queen(x):
    global count
    if x == N:
        count += 1
    else :
        for i in range(N):
            board[x] = i
            if check_position(x):
                set_queen(x+1)

set_queen(0)

print(count)