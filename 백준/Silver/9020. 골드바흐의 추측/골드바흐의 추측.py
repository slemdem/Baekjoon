import math

def give_prime(num):
    for i in range (2, int(math.sqrt(num) + 1)):	# 2부터 x의 제곱근까지의 숫자
        if num % i == 0:
            return False
    return True

T = int(input())

for i in range(T):
    n = int(input())
    prime1 = n//2 
    while True:
        if give_prime(prime1):
            rest = n - prime1
            if  give_prime(rest):
                print(prime1,rest)
                break
        prime1 -= 1