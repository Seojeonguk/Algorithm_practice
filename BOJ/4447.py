n = int(input())

for _ in range(n):
    name = input()
    if name.count('g') + name.count('G') > name.count('b')+name.count('B'): print(name + " is GOOD")
    elif name.count('g') + name.count('G') < name.count('b')+name.count('B'): print(name+" is A BADDY")
    else: print(name + " is NEUTRAL")
