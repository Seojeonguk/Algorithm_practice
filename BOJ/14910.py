arr = list(map(int,input().split()))

chk = 0
for _ in range(len(arr)-1):
    if arr[_] > arr[_+1]:
        chk = 1
        break

if chk==1:print("Bad")
else: print("Good")
