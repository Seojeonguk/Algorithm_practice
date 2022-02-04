import sys
input=sys.stdin.readline

n = int(input())

cnt=0
arr=[0]*n
chk=[0]*n

for _ in range(n):
    name = input().rstrip('\n')
    arr[_] = name

for _ in range(n):
    if chk[_]==1: continue
    chk[_] = 1
    cnt+=1
    for __ in range(_+1,n):
        double_name = arr[__]*2

        if len(arr[_]) == len(arr[__]) and arr[_] in double_name: chk[__]=1

print(cnt)
