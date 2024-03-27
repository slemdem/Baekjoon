def solution(land):
    chunkAmount = [0]
    chunks = [[0 for i in range(len(land[0]))]for i in range(len(land))]
    expects = [0 for i in range(len(land[0]))]
    delta = [(1,0),(-1,0),(0,1),(0,-1)]
    que = []
    for i in range(len(land[0])):
        counted = []
        for j in range(len(land)):
            if land[j][i] == 1:
                if chunks[j][i] == 0:
                    que.append([j,i])
                    index = len(chunkAmount)
                    chunk = 1
                    chunks[j][i] = index
                    while que:
                        x,y = que.pop()
                        for a,b in delta:
                            nx = x + a
                            ny = y + b
                            
                            if  0 <= nx < len(land) and 0 <= ny < len(land[0]):
                                if land[nx][ny] == 1 and chunks[nx][ny] == 0:
                                    chunk += 1
                                    chunks[nx][ny] = index
                                    que.append([nx,ny])
                                    
                    chunkAmount.append(chunk)
                    expects[i] += chunkAmount[chunks[j][i]]
                    counted.append(chunks[j][i])

                else :
                    if chunks[j][i] not in counted:
                        counted.append(chunks[j][i])
                        expects[i] += chunkAmount[chunks[j][i]]
                
    answer = max(expects)
    return answer