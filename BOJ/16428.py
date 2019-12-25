n,m = map(int,input().split())
op = 0
if m<0:
    m=-m
    op=1
if op==0: print(n//m)
else: print(-(n//m))
print(n%m)
