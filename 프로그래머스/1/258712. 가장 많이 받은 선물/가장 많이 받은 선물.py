def solution(friends, gifts):
    give_resive = [[0 for _ in range(len(friends))]for i in range(len(friends))]
    present_weight = [0] * len(friends)
    
    for i in range(len(gifts)):
        giver, reciver = gifts[i].split()
        giver = friends.index(giver)
        reciver= friends.index(reciver)
        give_resive[giver][reciver] += 1
        present_weight[giver] += 1
        present_weight[reciver] -= 1
    
    
    next_recive = [0] * len(friends)
    for i in range(len(friends)):
        for j in range(i,len(friends)):
            if(give_resive[i][j] > give_resive[j][i]):
                next_recive[i] += 1
            elif(give_resive[j][i] > give_resive[i][j]):
                next_recive[j] += 1
            else:
                if(present_weight[i] > present_weight[j]):
                    next_recive[i] += 1
                elif(present_weight[j] > present_weight[i]):
                    next_recive[j] += 1
    answer = max(next_recive)
    return answer