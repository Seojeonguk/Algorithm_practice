n = int(input())
home = []
away = []
for _ in range(0,n):
    a,b= map(int,input().split())
    home.append(a)
    away.append(b)
    
ans=0
for _ in home: ans += away.count(_)
for _ in away: ans += home.count(_)

print(ans//2)
