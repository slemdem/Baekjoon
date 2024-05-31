dice = list(map(int,input().split()))

if dice[0] == dice[1] :
    if dice[0] == dice[2] :
        print(10000+dice[0]*1000)
    else:print(1000+dice[0]*100)
elif dice[2] == dice[0] or dice[2] == dice[1] :
    print(1000+dice[2]*100)
else: print(max(dice)*100)