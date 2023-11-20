height, width = map(int,input().split())

pushedCnt=0
for _ in range(height):
    rowState = input()
    pushedCnt += rowState.count('0')
    
print(min(pushedCnt, height*width-pushedCnt))
