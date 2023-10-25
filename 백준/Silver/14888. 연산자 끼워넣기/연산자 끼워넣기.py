import sys
input = sys.stdin.readline

def operation_cases(n, x, list1, list2):
    if n == N-1:
        operation.append(list2.copy())  # 중복된 리스트가 아닌 복사본을 추가
    else:
        if list1[x] != 0:
            copylist = list1.copy()
            list2[n] = x
            copylist[x] -= 1
            for i in range(4):
                operation_cases(n+1, i, copylist, list2)
        else:
            return

N = int(input())
arr = list(map(int, input().split()))
operator = list(map(int, input().split()))

operation = []
unique_operations = set()  # 중복을 방지하기 위한 세트

for i in range(4):
    operatorcopy = operator.copy()
    operlist = [0 for i in range(N-1)]
    operation_cases(0, i, operatorcopy, operlist)
    unique_operations.update(tuple(op) for op in operation)  # 중복 제거를 위해 세트 업데이트

operation = [list(op) for op in unique_operations]

maxvalue = -1000000000
minvalue = 1000000000 
for i in range(len(operation)):
    result = arr[0]
    for j in range(len(operation[i])):
        if operation[i][j] == 0:
            result = result + arr[j+1]
        if operation[i][j] == 1:
            result = result - arr[j+1]
        if operation[i][j] == 2:
            result = result * arr[j+1]
        if operation[i][j] == 3:
            result = int(result / arr[j+1])
    if result > maxvalue :
        maxvalue = result
    if result < minvalue :
        minvalue = result
        
print(maxvalue)
print(minvalue)