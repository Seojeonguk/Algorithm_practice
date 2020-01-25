sc_msg = ["000000","001111","010011","011100","100110","101001","110101","111010"]

n = int(input())

msg = input()
ans = ""

for x in range(n):
    tmp = msg[6*x:6*(x+1)]
    for i in range(8):
        cnt=0
        for j in range(6):
            if tmp[j] != sc_msg[i][j]: cnt+=1
            
        if cnt<2:
            ans+= chr(ord("A")+i)
            break

    if cnt>=2:
        print(x+1)
        exit(0)

print(ans)
