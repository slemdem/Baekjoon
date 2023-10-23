import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**8)

def DFS(node,color):
    global Bipartite
    DFSvisited.add(node)
    
    if color == 'red':
        set_red.add(node)
        for i in arr[node]:
            if i in set_red: Bipartite = False
            if i not in DFSvisited:
                DFS(i,'blue')

    else:
        set_blue.add(node)
        for i in arr[node]:
            if i in set_blue: Bipartite = False
            if i not in DFSvisited:
                DFS(i,'red')

K = int(input())

for i in range(K):
    V, E = list(map(int, input().split()))
    arr =  [[] for _ in range(V+1)]
    for i in range(E):
        start, end = map(int, input().split())
        arr[start].append(end)
        arr[end].append(start)
    
    Bipartite = True
    DFSvisited = set()
    set_red = set()
    set_blue = set()
    for j in range(1,V+1):
        if j not in DFSvisited:
            DFS(j,'red')
    
    if Bipartite == True:
        print('YES')
    else:
        print('NO')