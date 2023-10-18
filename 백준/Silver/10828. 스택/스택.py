import sys
N = int(sys.stdin.readline())
stack = []

for i in range(N):
    comand = sys.stdin.readline().strip().split()
    if 'push' == comand[0]:
        push_i = int(comand[1])
        stack.append(push_i)
        
    elif comand[0] == 'top' :
        if len(stack) <= 0:
            print(-1)
        else:
            print(stack[-1])
            
    elif comand[0] == 'pop':
        if len(stack) <= 0:
            print(-1)
        else:
            print(stack.pop())
            
    elif comand[0] == 'size':
        print(len(stack))
        
    elif comand[0] == 'empty':
        if len(stack) <= 0:
            print(1)
        else:
            print(0)