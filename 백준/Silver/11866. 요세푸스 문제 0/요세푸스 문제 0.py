from collections import deque

inputs = list(map(int,input().split()))
N = int(inputs[0])
K = int(inputs[1])

people = []
result = []
for i in range(1,N+1):
    people.append(i)

def delete_people(arr, a):
    que = deque(arr)
    while True:
        if len(que) == 1:
            result.append(que.popleft())
            return
        for i in range(a-1):
            que.append(que.popleft())
        result.append(que.popleft())

delete_people(people, K)

for i in range(N):
    if N == 1:
        print('<', result[i], '>',sep='')
        break
    if i == 0 :
        print('<', result[i], ',',sep='',end=' ')
    elif i == N-1:
        print(result[i], '>',sep='')
    else:
        print(result[i],',',sep='',end=' ')