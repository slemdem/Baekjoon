import sys
input = sys.stdin.readline


L = int(input())
A = list(map(int,input().split()))
lcsarr = [1 for i in range(L)]
atributearr = [[i] for i in A]

for i in range(L):
    for j in range(i):
        if A[i] > A[j] and lcsarr[i] < lcsarr[j] + 1:
            lcsarr[i] = lcsarr[j] + 1
            atributearr[i] = atributearr[j]+[A[i]]

print(max(lcsarr))
print(*atributearr[lcsarr.index(max(lcsarr))])