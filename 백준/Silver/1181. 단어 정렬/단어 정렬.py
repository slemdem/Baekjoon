N = int(input())
arr = []
for i in range(N):
    word = input()
    if word in arr:
        continue
    arr.append( word )

arr.sort()
arr.sort(key=len)

for i in range(len(arr)):
    print(arr[i])