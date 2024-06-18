import sys
input = sys.stdin.readline

N = int(input().strip())
nums = list(map(int,input().split()))
x = int(input().strip())
nums.sort()

answer = 0

p = len(nums)-1

for i in range(len(nums)):
    if p <=i:
        break
    while  nums[i] + nums[p] > x and p > i:
        p -=1
    if p > i and nums[i] + nums[p] == x:
        answer += 1

print(answer)