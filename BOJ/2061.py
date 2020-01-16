k,l = map(int,input().split())

for x in range(2,l):
    if k%x==0:
        print("BAD",x)
        exit(0)

print("GOOD")
