N = int(input())
paper = []
for i in range(N):
    paper.append(list(map(int,input().split())))
    
white = 0
blue = 0

def cut_paper(arr,width):
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
            global blue
            blue += 1
            return
        global white
        white += 1
        return
    
    else :
        half = width//2
        cut_paper([arr[i][:half] for i in range(half)], half)
        cut_paper([arr[i][:half] for i in range(half,width)], half)
        cut_paper([arr[i][half:width] for i in range(half)], half)
        cut_paper([arr[i][half:width] for i in range(half,width)], half)

cut_paper(paper,N)
print(white)
print(blue)