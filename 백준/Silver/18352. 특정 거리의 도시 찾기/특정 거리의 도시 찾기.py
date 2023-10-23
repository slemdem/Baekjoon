import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**9)

from collections import deque

def BFS(node, cnt):
    BFSdiscovered.add(node)
    node_distance[node] = cnt
    
    if cnt == K :
        return
    
    next_nodes = []
    for i in arr[node]:
        if i in node_distance and node_distance[i] > cnt +1:
            BFSdiscovered.discard(i)
            del node_distance[i]
        if i not in BFSdiscovered:
            BFSdiscovered.add(i)
            next_nodes.append(i)
            
    for i in next_nodes:
        BFS(i, cnt+1)
        

N, M, K, X = list(map(int, input().split()))
arr = [[] for _ in range(N)]

for i in range(M):
    x, y = list(map(int, input().split()))
    arr[x-1].append(y-1)

BFSdiscovered = set()
node_distance = {}
BFS(X-1,0)

print_node = []
for i in node_distance:
    if node_distance[i] == K:
        print_node.append(i+1)
        
if len(print_node) < 1:
    print(-1)
else:
    print_node.sort()
    for i in range(len(print_node)):
        print(print_node[i])