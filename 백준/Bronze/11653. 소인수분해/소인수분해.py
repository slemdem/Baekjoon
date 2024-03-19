import sys
input = sys.stdin.readline

N = int(input())
prime = [2]
devide = False
notin = 0

while (N > 1):
    devide = False
    for i in range(len(prime)):
        if N < prime[i]:
            print(N)
            exit

        if N % prime[i] == 0:
            print(prime[i])
            N = N // prime[i]
            devide = True
            break

    if devide == True : continue
    
    if prime[-1] == 2:
        j = 3
    else:
        j = prime[-1]+2

    for i in range(j,N+1,2):
        if N%i == 0:
            print(i)
            N = N // i
            prime.append(i)
            break