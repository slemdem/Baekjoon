from collections import defaultdict

def solution(edges):
    answer = [0, 0, 0, 0]
    inandout = defaultdict(lambda:[0,0])
    
    for s, e in edges:
        inandout[s][0] += 1
        inandout[e][1] += 1
            
    for h in inandout:
        if inandout[h][0] >= 2 and inandout[h][1] == 0: # 원점
            answer[0] = h
        elif inandout[h][0] == 0 and inandout[h][1] > 0: # 막대 모양 
            answer[2] += 1
        elif inandout[h][0] >= 2 and inandout[h][1] >= 2: # 8자 모양
            answer[3] += 1
    answer[1] = (inandout[answer[0]][0] - answer[2] - answer[3]) # 나머지는 도넛 모양
                
    return answer