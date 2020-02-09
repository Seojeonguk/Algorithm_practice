s = input().rstrip('\n').split()
ans=0
for _ in s :
    if int(_) > 0 : ans+=1

print(ans)
