from sys import stdin
def count_ones_in_binary_up_to(n):
    count = 0
    power_of_two = 1
    
    while power_of_two <= n:
        total_pairs = (n + 1) // (power_of_two * 2)
        remainder = (n + 1) % (power_of_two * 2)
        
        count += total_pairs * power_of_two
        count += max(0, remainder - power_of_two)
        
        power_of_two *= 2
        
    return count

def count_ones_between_A_and_B(A, B):
    return count_ones_in_binary_up_to(B) - count_ones_in_binary_up_to(A - 1)

# 예시 실행
A, B = map(int, stdin.readline().split())
result = count_ones_between_A_and_B(A, B)
print(result)