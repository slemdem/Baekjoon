import sys
input = sys.stdin.readline

N = int(input().strip())

for i in range(1,N+1):
    a, b = list(map(int, input().split()))
    print('Case #',i,': ',a,' + ',b,' = ',a+b,sep='')