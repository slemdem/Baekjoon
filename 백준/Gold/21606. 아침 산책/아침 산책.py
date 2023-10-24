import sys
sys.setrecursionlimit(10**8)

from collections import deque

def linked_outside(node):
    DFSvisited.append(node)
    count = 0
    for i in arr[node]:
        if i not in DFSvisited:
            if in_or_out[i-1] == 0:
                count += linked_outside(i)
            else:
                count += 1
    return count
    
def linked_inside(node):
    count = 0
    for i in arr[node]:
        if i not in DFSvisited:
            count += 1
    return count

N = int( input())
in_or_out = list(map(int, sys.stdin.readline().strip()))
arr =  [[] for _ in range(N+1)]

for i in range(N-1):
    start, end = map(int, sys.stdin.readline().split())
    arr[start].append(end)
    arr[end].append(start)
    
DFSvisited = []
routes = 0
for i in range(1,N+1):
    if in_or_out[i-1] == 0 and i not in DFSvisited:
        through_out_side = linked_outside(i)
        routes += through_out_side * (through_out_side -1)

for i in range(1,N+1):
    if i not in DFSvisited:
        routes += linked_inside(i)

print(routes)