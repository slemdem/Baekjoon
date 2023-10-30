import sys
input = sys.stdin.readline

T = int(input())

for i in range(T):
    N = int(input())
    applied = [[] for _ in range(N)]
    recruit = []
    
    for j in range(N):
        paper, interview = map(int, input().split())
        applied[j] = [paper, interview]
    
    applied.sort()
    recruit.append(applied[0])
    itvgrade = applied[0][1]
    
    for j in range(1,N):
        paper, interview = applied[j]
        
        if interview > itvgrade:
            continue
            
        recruit.append(applied[j])
        itvgrade = applied[j][1]
    
    print(len(recruit))