def cycle(a = 0,b = 0):
    global count
    next = (a+b) % 10
    count += 1
    if (b*10) + next == N:
        return True
    else:
        cycle(b,next)
        return True
    
N = int(input())
count = 0
if N >= 10 :
    n10 = N // 10
    n1 = N % 10
    cycle(n10,n1)
else:
    cycle(b=N)

print(count)