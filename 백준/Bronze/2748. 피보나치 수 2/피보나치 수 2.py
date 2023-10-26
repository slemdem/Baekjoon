import sys
input = sys.stdin.readline

def fibonachi(n):
    F = [1,1]
    
    for i in range(2,n):
        F.append(F[i-2]+F[i-1])
        
    return F

num = int(input())

fibo = fibonachi(num)
print(fibo[len(fibo)-1])