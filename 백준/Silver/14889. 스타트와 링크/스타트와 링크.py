import sys
input = sys.stdin.readline

N = int(input().strip())
synergy = [list(map(int,input().split())) for _ in range(N)]
visited = [0 for _ in range(N)]
result = int(1e9)

def make_team(index = 0, depth = 0):
    global result
    if depth == N//2:
        A = 0
        B = 0
        for i in range(N):
            for j in range(N):
                if visited[i] and visited[j]:
                    A += synergy[i][j]
                elif not visited[i] and not visited[j]:
                    B += synergy[i][j]
        result = min(result, abs(A-B))
        return
    
    for i in range(index,N):
        if not visited[i]:
            visited[i] = True
            make_team(i+1,depth+1)
            visited[i] = False

make_team()
print(result)