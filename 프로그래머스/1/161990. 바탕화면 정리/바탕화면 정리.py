def solution(wallpaper):
    file = []
    for i in range(len(wallpaper)):
        for j in range(len(wallpaper[i])):
            if wallpaper[i][j] == '#':
                file.append([i,j])
    file.sort()
    x1 = file[0][0]
    x2 = file[-1][0] +1
    
    file.sort( key = lambda x : x[1])
    y1 = file[0][1]
    y2 = file[-1][1] +1
    
    answer = [x1,y1,x2,y2]
    return answer