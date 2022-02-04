n,m =map(int,input().split())

ans = map(int,input().split())

gop = 1
for x in ans:
    gop *= x

print(gop%m)
