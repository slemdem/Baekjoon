import sys
input = sys.stdin.readline

def kruskalMST(node = 0):
    total = 0
    
    for i in arr:
        cost, start, end = i
        if nodes[start] != nodes[end] :
            total += cost
            find = max(nodes[start], nodes[end])
            union = min(nodes[start], nodes[end])
            for i in range(len(nodes)):
                if nodes[i] == find:
                    nodes[i] = union

    return total

N, V = map(int, input().split())
arr = list()
nodes = [i for i in range(N)]

for i in range(V):
    x, y, z= list(map(int, input().split()))
    arr.append([z,x-1, y-1])

arr.sort()
print(kruskalMST(arr))