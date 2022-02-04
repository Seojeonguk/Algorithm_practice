while(True) :
    N = int(input())
    if N==0:break
    tmp = 10
    while(True):
        if tmp < 10 : break
        tmp=0    
        while(N!=0):
            tmp = tmp + N % 10
            N //= 10
        N=tmp
    print(tmp)
