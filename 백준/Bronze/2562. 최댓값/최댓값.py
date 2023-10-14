list = []
max = 0
index = 1
for i in range(9):
    list.append( int(input()))
    if max < list[i]:
        max = list[i]
        index = i+1

print(max)
print(index)