import sys
input = sys.stdin.readline
sys.setrecursionlimit(10**8)
import heapq

def djicstra():
    heap = []
    heapq.heappush(heap,[0,0,0])
    visited[0][0] = -1
    while heap:
        broke, nowx, nowy = heapq.heappop(heap)
        
        if nowx == N-1 and nowy == N-1:
            return broke
        
        for i in range(4):
            nextx = nowx + nexts[i][0]
            nexty = nowy + nexts[i][1]
            if nextx >= 0 and nextx < N and nexty >= 0 and nexty < N and visited[nextx][nexty] == 0:
                if maze[nextx][nexty] == 0:
                    heapq.heappush(heap, [broke+1,nextx, nexty])
                else:
                    heapq.heappush(heap, [broke,nextx, nexty])
                visited[nextx][nexty] = 1
    return False
            
N = int(sys.stdin.readline().strip())
maze = [list(map(int, list(sys.stdin.readline().strip()))) for _ in range(N)]
visited = [[0 for _ in range(N)] for _ in range(N)]
nexts = ((1,0),(0,1),(-1,0),(0,-1))

print( djicstra())