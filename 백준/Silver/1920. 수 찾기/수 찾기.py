def is_in_array(arr, a):
    end = len(arr)
    start = 0
    mid = end//2
    while True:
        if arr[mid] == a:
            print(1)
            return
        if end - start == 1:
            if arr[start] ==a:
                print(1)
                return
            print(0)
            return
        if a > arr[mid]:
            start = mid
            mid = start + (end - start)//2
        if a < arr[mid]:
            end = mid
            mid = start + (end - start)//2

N = int(input())
A = input().split()
A.sort()

M = int(input())
B = input().split()
for i in range(M):
    is_in_array(A, B[i])