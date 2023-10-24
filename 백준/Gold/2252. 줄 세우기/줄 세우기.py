import sys
sys.setrecursionlimit(10**8)
input = sys.stdin.readline

def DFS(node):
    DFSvisited.append(node)
    for i in arr[node]:
        parent_num[i] -= 1
        if parent_num[i] == 0:
            DFS(i)

N, M = map(int, input().split())
arr =  [[] for _ in range(N+1)]
parent_num =  [0 for _ in range(N+1)]

for i in range(M):
    big, short = map(int, input().split())
    arr[big].append(short)
    parent_num[short] +=1

DFSvisited = []

for i in range(1,N+1):
    if parent_num[i] == 0 and i not in DFSvisited:
        DFS(i)

print(*DFSvisited)