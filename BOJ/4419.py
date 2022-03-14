n = int(input())

indicates=[]
for _ in range(n):
  indicates.append(input())

favours=[]
while True:
  try:
    favour = list(map(int,input().split()))
    favours.append(favour)
  except:
    break

ans=[]
eliminated=[0 for i in range(n)]


for _ in range(n):
  ballots = {}
  
  for i in range(n):
    if not eliminated[i]:
      ballots[i]=0
  
  for favour in favours:
    for x in favour:
      if not eliminated[x-1]:
        ballots[x-1]+=1
        break
  
  ballots = sorted(ballots.items(), key=lambda x:x[1])
  
  if ballots[0][1] == ballots[len(ballots)-1][1]:
    for ballot in ballots:
      ans.append(indicates[ballot[0]])
    break
  
  if ballots[len(ballots)-1][1] >= (len(favours)+1)//2:
    ans.append(indicates[ballots[len(ballots)-1][0]])
    break
  
  for ballot in ballots:
    if not ballot[1] == ballots[0][1]:
      break
    eliminated[ballot[0]] = 1

for x in ans:
  print(x)