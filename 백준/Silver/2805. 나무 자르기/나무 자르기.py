import sys
input = sys.stdin.readline

def cut_tree(arr,length):
    tall = max(arr)
    low = 0
    result = 0
    
    while low <= tall:
        mid = (tall+low)//2
        cutted = 0
        
        for i in range(N):
            if arr[i] > mid: 
                cutted += (arr[i] - mid)
        
        if cutted >= length :
            low = mid + 1
            result = mid
        else:
            tall = mid - 1
            
    return result

N, M = list(map(int,input().split()))
trees = list(map(int,input().split()))

print(cut_tree(trees,M))