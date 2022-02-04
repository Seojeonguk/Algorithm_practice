while(True):
    n = int(input())
    if n==0: break

    arr = list(map(int,input().split()))
    r=d=0
    chk=0
    ans=0
    now=arr[0]

    if arr[2]-arr[1] == arr[1]-arr[0]:
        d=arr[2]-arr[1]
        chk=1
    else:
        r = arr[2]//arr[1]
        chk=2

    if chk==1:
        for i in range(0,n):
            ans+=now
            now+=d
    else:
        for i in range(0,n):
            ans+=now
            now*=r

    print(ans)
