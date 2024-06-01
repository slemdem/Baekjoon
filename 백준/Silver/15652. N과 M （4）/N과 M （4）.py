import sys
input = sys.stdin.readline

N,M = list(map(int,input().split()))

def backtrack_series(series = [1 for _ in range(M)], n = 0):
    if n == M:
        for i in series:
            print(i,end=' ')
        print()
    else:
        for i in range(series[n-1],N+1):
            series[n] = i
            backtrack_series(series, n +1)

backtrack_series()