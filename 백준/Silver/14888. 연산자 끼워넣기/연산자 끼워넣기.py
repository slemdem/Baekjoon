import sys
input = sys.stdin.readline

N = int(input().strip())
Numbers = list(map(int,input().split()))
Operators = list(map(int,input().split())) # + - * //
results = []

def backtrackig_Operators(acc, used = [0,0,0,0], n=1):
    if n == N:
        results.append(acc)
    else:
        for i in range(len(used)):
            if Operators[i] - used[i] >0:
                if i == 0:
                    used[i]+=1
                    backtrackig_Operators(acc+Numbers[n], used, n+1)
                    used[i]-=1
                elif i == 1:
                    used[i]+=1
                    backtrackig_Operators(acc-Numbers[n], used, n+1)
                    used[i]-=1
                elif i == 2:
                    used[i]+=1
                    backtrackig_Operators(acc*Numbers[n], used, n+1)
                    used[i]-=1
                elif i == 3:
                    used[i]+=1
                    backtrackig_Operators(int(acc/Numbers[n]), used, n+1)
                    used[i]-=1

backtrackig_Operators(Numbers[0])
print(max(results))
print(min(results))
