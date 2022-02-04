n=int(input())
for _ in range(n):
        cnt=1
        score=0
        sum=0
        frame = input().split()

        for idx,x in enumerate(frame):
                if x == '/':
                        score += 10 - (int(frame[idx-1])-int('0'))
                        cnt+=1
                        sum=0
                        if frame[idx+1]=='X': score+=10
                        else: score+= int(frame[idx+1]) - int('0')
                elif x== 'X':
                        score+=10
                        cnt+=1
                        sum=0
                        if frame[idx+1]=='X': score+=10
                        else: score+=int(frame[idx+1])-int('0')

                        if frame[idx+2] == 'X': score+=10
                        elif frame[idx+2] == '/': score += 10-(int(frame[idx+1])-int('0'))
                        else: score+= int(frame[idx+2])-int('0')
                else:
                        score += int(x)- int('0')
                        sum+=1
                        if sum==2:
                                cnt+=1
                                sum=0
                if cnt==11: break
        print(score)
