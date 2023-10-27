import sys
input = sys.stdin.readline


A = input().strip()
B = input().strip()

lcsarr = [[0 for i in range(len(B)+1)] for i in range(len(A)+1)]

for i in range(1,len(A)+1):
    for j in range(1,len(B)+1):
        if A[i-1] == B[j-1]:
            lcsarr[i][j] = lcsarr[i-1][j-1] + 1
        else:
            lcsarr[i][j] = max(lcsarr[i-1][j],lcsarr[i][j-1])

print(lcsarr[len(A)][len(B)])