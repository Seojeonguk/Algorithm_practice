import sys
input=sys.stdin.readline

n = int(input())

car=[0]*n

for _ in range(n):
    name = input().rstrip('\n')
    car[_] = name

true_now=0
ans=0
increase=0
s = []
for _ in range(n):
    name = input().rstrip('\n')
    now = car.index(name)
    if s == []: s.append(now)
    else:
        if s[len(s)-1] > now:
                s.pop()
                ans+=1
        s.append(now)

print(ans)
