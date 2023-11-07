import sys
input = sys.stdin.readline

A = input().strip()
B = input().strip()

lcsarr = [[[0,''] for i in range(len(B)+1)] for i in range(len(A)+1)]

for i in range(len(A)):
    for j in range(len(B)):
        if A[i] == B[j]:
            lcsarr[i][j] = [lcsarr[i-1][j-1][0]+1,lcsarr[i-1][j-1][1]+A[i]]
        else :
            lcsarr[i][j] = max(lcsarr[i-1][j],lcsarr[i][j-1])
            
print(lcsarr[len(A)-1][len(B)-1][0])
print(lcsarr[len(A)-1][len(B)-1][1])