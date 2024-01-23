import sys
from collections import deque
input = sys.stdin.readline

N,K = map(int,input().split())

A = deque(list(map(int,input().split())))
R = deque([0]*N)
stage = 0
while True:
    deque.appendleft(A,deque.pop(A))
    deque.appendleft(R,deque.pop(R))
    R[N-1] = 0
    
    for i in range(N-1,-1,-1):
        if (R[i] == 1 and A[i+1] > 0 and R[i+1] != 1):
            R[i] = 0
            R[i+1] = 1
            A[i+1] -= 1

    R[N-1] = 0
    
    if A[0] > 0 :
        A[0] -= 1
        R[0] = 1
    
    stage +=1
    if (A.count(0) >= K):
        break
    
print(stage)