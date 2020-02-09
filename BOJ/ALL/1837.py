p,k = map(int,input().split())
chk = [0 for i in range(k*2)]

for i in range(2,k*2,1):
    if chk[i] != 0: continue
    for j in range(i*2,k*2,i):
        chk[j] = 1

ans = 0
for i in range(2,k):
    if chk[i] == 1: continue
    if p%i==0:
        ans = i
        break

if ans != 0: print("BAD", ans)
else: print("GOOD")
