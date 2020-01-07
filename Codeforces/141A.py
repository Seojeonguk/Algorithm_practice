a=input()
b=input()
c=input()
a+=b
if len(a)!=len(c):
    print("NO")
    exit(0)

for x in c:
    idx = a.find(x)
    if idx != -1: a = a[0:idx] + a[idx+1:]
    else:
        print("NO")
        exit(0)

print("YES")
