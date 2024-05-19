def solution(arr):
    answer = [arr[0]]
    last = arr[0]
    for i in arr:
        if i != last:
            answer.append(i)
            last = i
    return answer