def fibonachi(n):
    
    for i in range(2,n):
        F.append((F[i-2]+F[i-1])%15746)
        
    return F


num = int(input())

F = [1,2]
fibonachi(num)
print(F[num-1])