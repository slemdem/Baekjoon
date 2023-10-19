def preorder_traversal(row):
    T = tree[row]
    print(T[0],end='')
    
    for i in range(1,len(T)):
        if T[i] !='.':
            nextrow = [j for j in range(N) if tree[j][0] == T[i]]
            preorder_traversal(nextrow[0])

def inorder_traversal(row):
    T = tree[row]
    if T[1] !='.':
        nextrow = [i for i in range(N) if tree[i][0] == T[1]]
        inorder_traversal(nextrow[0])
        
    print(T[0],end='')
    
    if T[2] !='.':
        nextrow = [i for i in range(N) if tree[i][0] == T[2]]
        inorder_traversal(nextrow[0])

def postorder_traversal(row):
    T = tree[row]
    for i in range(1,len(T)):
        if T[i] !='.':
            nextrow = [j for j in range(N) if tree[j][0] == T[i]]
            postorder_traversal(nextrow[0])
            
    print(T[0],end='')

N = int(input())

tree = []

for i in range(N):
    tree.append(input().split()) 

preorder_traversal(0)
print()

inorder_traversal(0)
print()

postorder_traversal(0)
print()