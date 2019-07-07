t = int(input())

for _ in range(t):
    channel = input()
    if(channel == 'KBS1'): one = _
    if(channel == 'KBS2'): two = _

for _ in range(one): print('1',end="")
for _ in range(one): print('4',end="")

if(two < one): two= two+1
for _ in range(two): print('1',end="")
for _ in range(two-1): print('4',end="")
    

