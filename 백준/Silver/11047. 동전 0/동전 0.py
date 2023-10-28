import sys
input = sys.stdin.readline

def cange(n,coin):
    value = n // coin
    return value

N, K = map(int, input().split())
coins = []

for i in range(N):
    coins.append(int(input()))

cnt = 0
i = 1
while K != 0 :
    cnt += cange(K,coins[N-i])
    K = K % coins[N-i]
    i += 1

print(cnt)