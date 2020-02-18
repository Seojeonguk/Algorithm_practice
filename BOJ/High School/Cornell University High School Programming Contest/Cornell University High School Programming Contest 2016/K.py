import re
n = int(input())
of_words = ['of','to','into','onto','above','below','from','by','is','at']
vowl = "aeiou"
cnt=0
for i in range(n):
        s = input().lower().split()
        for str in s:
                if cnt > 20:
                        print()
                        cnt=0

                if str in of_words:
                        print('of',end=' ')
                        cnt+=2
                        continue

                str = re.sub('[^a-z]',"",str)

                tmp=0
                for x in vowl: tmp+=str.count(x)
                tmp//=2
                idx = 0

                for x in range(tmp):
                        for tmp,y in enumerate(str):
                                if y in vowl:
                                        idx = tmp
                                        break
                        str = str[:idx] + str[idx+1:]
                if len(str)!=0:
                        print(str,end=' ')
                        cnt+=len(str)
