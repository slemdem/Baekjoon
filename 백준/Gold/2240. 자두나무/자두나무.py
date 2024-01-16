import sys
input = sys.stdin.readline

N,M = map(int,input().split())
plumes=[]

for i in range(N):
    plumes.append(int(input()))
                
results = [[0 for _ in range(N+1)]for i in range(M+1)]

for i in range(M+1):
    move = i
    now = 1
    for j in range(1,N+1):
        if (i == 0) :
            results[i][j] = results[i][j-1] + (plumes[j-1]==now)
        else:
            if(move > 0 and plumes[j-1] != now):
                move -=1
                now = plumes[j-1]
            results[i][j] = max(results[i][j-1],results[i-1][j-1]) + (plumes[j-1]==now)
            
print(results[M][N])