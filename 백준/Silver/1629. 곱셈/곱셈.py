import sys  
sys.setrecursionlimit(10**8)

def do_cal(x, y):
    if y == 1:
        return x%C
    
    if y % 2 == 0:
        return do_cal(x, y//2)**2%C
    else :
        return x * do_cal(x, y//2)**2%C

A, B, C = list(map(int,sys.stdin.readline().split()))
result = do_cal(A,B)
print(result % C)