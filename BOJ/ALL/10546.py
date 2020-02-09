from sys import stdin
t = int(input())
arr={}

for _ in range(t):
    name = stdin.readline()
    try:arr[name]+=1
    except:arr[name]=1

for _ in range(t-1):
    complete_name = stdin.readline()
    arr[complete_name]-=1

for _ in arr.keys():
    if arr[_]==1:print(_)
