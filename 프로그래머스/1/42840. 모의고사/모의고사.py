def solution(answers):
    supojas = [[1,2,3,4,5], [2,1,2,3,2,4,2,5], [3,3,1,1,2,2,4,4,5,5]]
    scores = [0 for _ in range(3)]
    answer = []
    for i in range(len(answers)):
        for j in range(len(supojas)):
            guess = supojas[j][i%len(supojas[j])]
            if answers[i] == guess:
                scores[j] += 1

    for i in range(len(scores)):
        if scores[i] == max(scores):
            answer.append(i+1)
    return answer