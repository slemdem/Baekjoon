import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**8)

def so_you_have_a_mother(node):
    DFSvisited.add(node)
    for i in arr[node]:
        if i not in DFSvisited:
            parent_of[i] = node
            so_you_have_a_mother(i)
            
            
N = list(map(int, input().split()))[0]
arr =  [[] for _ in range(N+1)]

for i in range(N-1):
    x, y = map(int, input().split())
    arr[x].append(y)
    arr[y].append(x)

DFSvisited = set()
parent_of = [0 for _ in range(N+1)]
so_you_have_a_mother(1)


for i in range(2,len(parent_of)):
    print(parent_of[i])