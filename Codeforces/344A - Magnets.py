t = int(input())
ans=0
prev=""

for _ in range(t):
    magnets = input()
    if prev != magnets:
        prev = magnets
        ans+=1

print(ans)
