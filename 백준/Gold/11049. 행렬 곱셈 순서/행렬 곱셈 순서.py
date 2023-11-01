import sys
input = sys.stdin.readline

N = int(input())
arr = [[] for i in range(N)]

for i in range(N):
    arr[i] = list(map(int, input().split()))
    
DP = [[0 for _ in range(N)] for _ in range(N)]

for i in range(N-1, -1, -1):
    for j in range(i+1,N):
        DP[i][j] = min([(DP[i][k]+DP[k+1][j]+(arr[i][0]*arr[k+1][0]*arr[j][1])) for k in range(i,j)])

print(DP[0][-1])