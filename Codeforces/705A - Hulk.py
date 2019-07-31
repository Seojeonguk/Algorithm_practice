n = int(input())

for x in range(n):
    if x%2: print("I love ",end="")
    else: print("I hate ", end="")
    if x+1 != n: print("that ", end="")
print("it")
