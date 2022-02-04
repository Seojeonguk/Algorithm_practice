n = int(input())
ans = 1000000000
for a in range(1, n + 1):
    if n % a != 0:
        continue
    for b in range(1, n//a + 1):
        if n % (a*b) == 0:
            c = n//a//b
            ans = min(ans, 2*(a*b+b*c+c*a))
print(ans)
