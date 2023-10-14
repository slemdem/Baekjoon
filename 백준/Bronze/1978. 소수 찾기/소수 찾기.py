N = int(input())
prime = []
str = input().split(' ')

for i in range(N):
    p = int(str[i])
    isprime = True
    for j in range(2,p-1):
        if p % j == 0:
            isprime = False
            break
    if isprime == True and p != 1:
        prime.append(p)

print(len(prime))