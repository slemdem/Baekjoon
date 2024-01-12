def solution(cap, n, deliveries, pickups):
    answer = 0
    logGo = n
    logcome = n
    while True:
        nowcap = cap
        destanceGo = 0
        for i in range(logGo,0,-1):
            if(nowcap<=0):
                break
            if(deliveries[i-1] == 0): continue
            
            if(deliveries[i-1]<=nowcap):
                nowcap -= deliveries[i-1]
                deliveries[i-1] = 0
                logGo = i
            else:
                deliveries[i-1] -= nowcap
                nowcap = 0
                
            if(destanceGo < i):
                destanceGo = i
                
        nowcap = cap
        destanceCome = 0
        for i in range(logcome,0,-1):
            if(nowcap <= 0):
                break
            if(pickups[i-1]==0):continue
            
            if(pickups[i-1]<=nowcap):
                nowcap -= pickups[i-1]
                pickups[i-1] = 0
                logcome = i
            else:
                pickups[i-1] -= nowcap
                nowcap = 0
            if(destanceCome < i):
                destanceCome = i
        
        answer += 2*max(destanceGo,destanceCome)
        if(destanceCome == 0 and destanceGo == 0):
            break
        
    return answer