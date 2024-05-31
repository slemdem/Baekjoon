num1,num2 = list(map(int,input().split()))

if num1 == num2:
    print('==')
elif num1 > num2:
    print('>')
else:
    print('<')