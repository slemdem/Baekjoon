import sys
sys.setrecursionlimit(10000)

class TreeNode:
    def __init__(self, value=0):
        self.item = value
        self.left = None
        self.right = None
        
    def node_value(self):
        return self.item
    
    def add_left(self, value):
        newnode = TreeNode(value)
        self.left = newnode
        
    def add_right(self, value):
        newnode = TreeNode(value)
        self.right = newnode
    
    def add_node(self, value):
        if value < self.item:
            if self.left is not None:
                self.left.add_node(value)
            else:
                self.add_left(value)
        else:
            if self.right is not None:
                self.right.add_node(value)
            else:
                self.add_right(value)

def postorder_traversal(node: TreeNode):
    if node.left is not None:
        postorder_traversal(node.left)
    
    if node.right is not None:
        postorder_traversal(node.right)
    
    print(node.node_value())

# 입력 받기
n = 0
try:
    first = int(input().strip())
    n += 1
except:
    pass

root = TreeNode(first)

while True:
    try:
        push = int(input().strip())
        root.add_node(push)
        n += 1
    except:
        break

if root.item != 0:
    postorder_traversal(root)