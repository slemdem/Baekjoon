import sys
input = sys.stdin.readline

N = int(input())
stair = [0]*301
for i in range(N):
    stair[i]=int(input())

results = [0] * 301
results[0] = stair[0]
results[1] = stair[0] + stair[1]
results[2] = max(stair[0], stair[1])+ stair[2]

for i in range(3,N):
    results[i] = max(results[i-3] + stair[i-1], results[i-2]) + stair[i]

print(results[N-1])