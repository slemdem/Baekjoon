import sys
input = sys.stdin.readline

N = int(input().strip())
scores = list(map(float,input().split()))

M = max(scores)

for i in range(len(scores)):
    scores[i] = scores[i]/M*100

print(sum(scores)/N)