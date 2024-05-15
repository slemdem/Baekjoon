def solution(sequence, k):
    if k in sequence:
        a=sequence.index(k)
        return [a,a]
    # answers = []
    # dp = [[0 for _ in range(len(sequence))] for __ in range(len(sequence))]
    # dp[0] = sequence
    # for i in range(1,len(sequence)):
    #     for j in range(i,len(sequence)):
    #         dp[i][j] = dp[i-1][j-1] + sequence[j]
    #         if dp[i][j] == k:
    #             return[j-i,j]
            
    num = 0
    for i in range(len(sequence)-1, -1, -1):
        num += sequence[i]
        if num > k:
            num -= sequence.pop() 
        if num == k:
            while sequence[i-1] == sequence[-1] and i>0:
                i-=1
                sequence.pop()

            return [i, len(sequence)-1]