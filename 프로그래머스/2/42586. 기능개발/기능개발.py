def solution(progresses, speeds):
    answer = []
    dates = []
    last = 0
    for i in range(len(progresses)):
        onprocess = (100 - progresses[i]) // speeds[i] 
        if (100 - progresses[i]) % speeds[i] != 0:
            onprocess += 1
            dates.append(onprocess)
        else: dates.append(onprocess)
        
        if last == 0: last = onprocess
        elif onprocess > last:
            answer.append(len(dates)-1)
            last = onprocess
            dates = [onprocess]
    answer.append(len(dates))
    # deploy = 0
    # last = dates[0]
    # for i in dates:
    #     if i <= last:
    #         deploy += 1
    #     else:
    #         answer.append(deploy)
    #         deploy = 1
    #         last = i
    # answer.append(deploy)
    return answer