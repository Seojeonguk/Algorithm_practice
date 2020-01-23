n,m = map(int,input().split())

b = [x for x in range(1,n+1)]

for x in range(m):
    i,j,k = map(int,input().split())
    i-=1
    j-=1
    k-=1
    b = b[:i]+b[k:j+1]+b[i:k]+b[j+1:]

print(*b)
