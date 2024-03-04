import math
for _ in range(int(input())):
    x, y = map(int, input().split(" "))

    fac = math.factorial(x)
    print(str(fac).count(str(y)))