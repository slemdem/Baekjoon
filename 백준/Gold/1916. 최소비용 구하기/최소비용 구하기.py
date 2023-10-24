import heapq
import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**8)

def findway(node):
    que = arr[node]
    while que:
        weight, now = heapq.heappop(que)
        if now not in nodes:
            nodes.append(now)
            graph[now] = weight
            for i in range(len(arr[now])):
                nextweight, nextnode = arr[now][i]
                if nextnode not in nodes:
                    heapq.heappush(que,[weight+nextweight,nextnode])
    
N = int(input())
M = int(input())
arr =  [[] for i in range(N)]

for i in range(M):
    s, e, c = map(int, input().split())
    arr[s-1].append([c,e-1])

for i in range(N):
    arr[i].sort()

start, end = map(int, input().split())

nodes = [start-1]
graph = [sys.maxsize for i in range(N)]

findway(start-1)

print(graph[end-1])