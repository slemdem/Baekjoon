list = []
max = 0
index = 1
for i in range(9):
    j = int(input())
    if max < j:
        max = j
        index = i+1

print(max)
print(index)