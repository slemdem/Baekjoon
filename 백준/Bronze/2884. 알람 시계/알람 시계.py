hours, minutes = list(map(int,input().split()))

if minutes >= 45:
    print(hours, minutes-45)
else :
    if hours == 0: hours = 24
    rest = minutes - 45
    print(hours-1, 60+rest)