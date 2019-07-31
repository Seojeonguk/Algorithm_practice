n = int(input())
iq = list(map(int,input().split()))
even = odd = cnt = 0
for x in range(n):
    if iq[x]%2:
        cnt-=1
        odd = x+1
    else :
        cnt+=1
        even = x+1

if cnt > 0: print(odd)
else : print(even)
