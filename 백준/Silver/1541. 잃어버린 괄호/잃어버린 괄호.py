import sys
input = sys.stdin.readline

N = input().split('-')

if len(N) == 1:
    braket = list(map(int,N[0].split('+')))
    braketcal = 0
    for i in range(len(braket)):
        braketcal += braket[i]
    print(braketcal)
    exit()
    
cal = 0
for i in range(len(N)):
    braket = list(map(int,N[i].split('+')))
    braketcal = 0
    for j in range(len(braket)):
        braketcal += braket[j]
    if i >= 1:
        cal -= braketcal
    else:
        cal += braketcal

print(cal)