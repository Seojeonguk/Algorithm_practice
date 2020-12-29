n = int(input())

ans=0
for x in range(n):
    arr = map(int,input().split())
    m = max(arr)
    if m >0: ans+=m

print(ans)
