def solution(cards1, cards2, goal):
    sucess = True
    count1 = 0
    count2 = 0
    for i in range(len(goal)):
        passed = False
        if count1 < len(cards1) :
            if (goal[i] == cards1[count1]):
                passed = True
                count1 += 1
        if count2 < len(cards2):
            if (goal[i] == cards2[count2]):
                passed = True
                count2 += 1
            
        if passed != True:
            sucess = False
            break
    
    if sucess == True: 
        answer = 'Yes'
    else: 
        answer = 'No'
    
    return answer