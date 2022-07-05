x = y = 56

y = 42

print(y)
print(x)


class ListNode(object):
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next

x = y = ListNode(0)

y.next = 4

print(x.next)

name = "Zen"
print("My name is", name)

name = "Zen"
print("My name is " + name)