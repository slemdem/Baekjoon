import sys
input = sys.stdin.readline

N = int(input())
arr = [[] for i in range(N)]

for i in range(N):
    s, e = map(int, input().split())
    arr[i] = [s, e]
    
arr.sort(key=lambda x : (x[1],x[0]))
stack = []
recent = 0

for i in range(len(arr)):
    s, e = arr[i]
    if recent > s:
        continue
    else :
        recent = e
        stack.append(arr[i])

print(len(stack))