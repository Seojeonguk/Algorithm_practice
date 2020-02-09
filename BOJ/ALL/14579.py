a,b =map(int,input().split())
ans=1
pl=0
for _ in range(a): pl += _
for _ in range(a,b+1):
    pl += _
    ans *= pl

print(ans%14579)
