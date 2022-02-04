import sys
input=sys.stdin.readline

while(1):
    text = input().rstrip('\n')
    if text == "*": break
    pass_or_fail=1 # 0:놀랍지 않은 문자 1:놀라운 문자

    for _ in range(1,len(text)):
        surprising = []
        for x in range(len(text)-_):
            chk = text[x]+text[x+_]
            if chk in surprising:
                pass_or_fail = 0
                break
            surprising.append(chk)

        if pass_or_fail==0: break
        

    print(text, "is NOT" if pass_or_fail==0 else "is" , "surprising.")
