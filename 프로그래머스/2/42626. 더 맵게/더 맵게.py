import heapq

def solution(scoville, K):
    heapq.heapify(scoville)
    answer = 0
    
    while len(scoville)>1:
        min_scoville1 = heapq.heappop(scoville)
        if min_scoville1 >= K:
            break
        min_scoville2 = heapq.heappop(scoville)
        
        heapq.heappush(scoville, min_scoville1 + (min_scoville2 * 2))
            
        answer+=1
        
    if scoville[0] < K: return -1
    return answer