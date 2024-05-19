def solution(progresses, speeds):
    answer = []
    dates = []
    for i in range(len(progresses)):
        if (100 - progresses[i]) % speeds[i] != 0:
            dates.append((100 - progresses[i]) // speeds[i] + 1)
        else: dates.append((100 - progresses[i]) // speeds[i])
    deploy = 0
    last = dates[0]
    for i in dates:
        if i <= last:
            deploy += 1
        else:
            answer.append(deploy)
            deploy = 1
            last = i
    answer.append(deploy)
    return answer