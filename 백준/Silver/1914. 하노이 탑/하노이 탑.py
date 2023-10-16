def hanoi(n,start,via,to):
    if n <= 1:
        print(start,to)
        return 
    hanoi(n-1,start,to,via)
    print(start,to)
    hanoi(n-1,via,start,to)

n = int(input())

print(2**n -1)
if n<=20 :
    hanoi(n,1,2,3)