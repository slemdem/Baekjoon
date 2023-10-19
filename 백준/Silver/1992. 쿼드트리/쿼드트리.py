import re

N = int(input())
image = []
for i in range(N):
    row = input()
    image.append(list(map(int,re.findall(r'\d', row))))
    
def quad_tree(arr,width):
    color = arr[0][0]
    onecolor = True
    
    for i in range(width):
        if onecolor == False: break
        for j in range(width):
            if arr[i][j] != color:
                onecolor = False
                break
    if onecolor == True:
        if color == 1:
            print(1,end='')
            return
        else:
            print(0,end='')
            return
    
    else :
        half = width//2
        print('(',end='')
        quad_tree([arr[i][:half] for i in range(half)], half)
        quad_tree([arr[i][half:width] for i in range(half)], half)
        quad_tree([arr[i][:half] for i in range(half,width)], half)
        quad_tree([arr[i][half:width] for i in range(half,width)], half)
        print(')',end='')

quad_tree(image,N)