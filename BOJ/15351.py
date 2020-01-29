t = int(input())

for x in range(t):
    name = input()
    ans=0
    for x in name:
        if 'A'<=x<='Z': ans+= ord(x)-ord('A')+1
        else: continue

    if ans==100: print("PERFECT LIFE")
    else: print(ans)
