import sys
input = sys.stdin.readline
N = int(input())
stack = []
LP = -1
RP = -1

for i in range(N):
    comand = input().split()
    if 'push' == comand[0]:
        push_i = int(comand[1])
        stack.append(push_i)
        RP = RP + 1
            
    elif comand[0] == 'pop':
        if RP - LP <= 0:
            print(-1)
        else:
            print(stack[LP+1])
            LP = LP + 1
            
    elif comand[0] == 'size':
        print(RP - LP)
        
    elif comand[0] == 'empty':
        if RP - LP <= 0:
            print(1)
        else:
            print(0)

    elif comand[0] == 'front' :
        if RP - LP <= 0:
            print(-1)
        else:
            print(stack[LP+1])

    elif comand[0] == 'back' :
        if RP - LP <= 0:
            print(-1)
        else:
            print(stack[RP])