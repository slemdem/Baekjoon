import sys
input = sys.stdin.readline

N = int(input().strip())

for i in range(N):
    a, b = list(map(int, input().split()))
    print(a+b)