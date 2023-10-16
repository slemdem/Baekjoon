import random

height = [0]*9
for i in range(9):
    height[i] = int(input())

sum = 0
calculated = []
rightheight = []
while True:
    randint = int(random.randrange(0,9))
    if randint not in calculated:
        sum += height[randint]
        calculated.append(randint)
        rightheight.append(height[randint])
    if sum > 100: 
        sum = 0
        calculated = []
        rightheight = []
    if sum == 100 and len(rightheight) == 7:
        break

rightheight.sort()

for i in range(7):
    print(rightheight[i])