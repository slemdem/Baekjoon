def solution(food):
    for i in range(1,len(food)):
        food[i] = food[i]//2
    
    answer = ''
    for i in range(1,len(food)):
        for j in range(food[i]):
            answer = answer + str(i)
    answer = answer + '0'
    for i in range(len(food)-1,0,-1):
        for j in range(food[i]):
            answer = answer + str(i)
    return answer