n = int(input())
arr = list(map(str,input().split()))

for idx,x in enumerate(arr,1):
    y=0
    if x=="mumble": continue
    y = int(x)
    if y!=idx:
        print("something is fishy")
        exit(0)

print("makes sense")
