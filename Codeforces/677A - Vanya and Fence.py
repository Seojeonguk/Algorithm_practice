n,h = map(int,input().split())
ans=0
a = list(map(int,input().split()))

for _ in a:
    ans+=_//h
    if _ % h : ans+=1

print(ans)
