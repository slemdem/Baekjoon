import sys
input = sys.stdin.readline

T = int(input())

for i in range(T):
    coinnum = int(input())
    coins = list(map(int,input().split()))
    value = int(input())
    cases = [0 for i in range(value+1)]
    cases[0] = 1
    
    for i in coins:
        for j in range(i,value+1):
            cases[j] = cases[j]+cases[j-i]
    
    print(cases[value])