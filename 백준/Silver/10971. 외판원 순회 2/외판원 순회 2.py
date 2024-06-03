import sys
input = sys.stdin.readline

N = int(input().strip())
city_map = [list(map(int,input().split())) for _ in range(N)]
visited = [0 for _ in range(N)]
result = int(1e9)

def TSP(startfrom,start, route = 0, depth = 0):
    global result
    if depth == N-1:
        if not city_map[start][startfrom]: return
        route += city_map[start][startfrom]
        visited[startfrom] = True
        for i in visited:
            if i == False: return
        result = min(result, route)
        return
    
    for i in range(len(city_map[start])) :
        if i!=startfrom and city_map[start][i] and not visited[i]:
            visited[i] = True
            TSP(startfrom,i,route+city_map[start][i],depth+1)
            visited[i] = False

for i in range(N):
    TSP(i,i)
print(result)