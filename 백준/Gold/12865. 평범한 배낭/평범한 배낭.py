import sys
input = sys.stdin.readline

N,K = map(int,input().split())
stuff = []
Bag = [[0 for j in range(K+1)] for i in range(N+1)]
MAXV = 0


for i in range(N):
    W,V = map(int,input().split())
    stuff.append([W,V])

for i in range(1,N+1):
    occupied = 0
    for j in range(1,K+1):
        
        if stuff[i-1][0] <= j:
            Bag[i][j] = max(Bag[i-1][j], Bag[i-1][ j-stuff[i-1][0] ] + stuff[i-1][1])
        else:
            Bag[i][j] = Bag[i-1][j]
        
print(Bag[N][K])