import sys
input = sys.stdin.readline

N = int(input().strip())
nums = list(map(int,input().split()))

print(min(nums),max(nums))