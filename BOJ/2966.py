n=int(input())
answer = input()
Adrian = "ABC"
Bruno = "BABC"
Goran = "CCAABB"

Adrian *= 34
Bruno *= 25
Goran *= 17

o = [0 for x in range(3)]
name=["Adrian","Bruno","Goran"]

for idx, x in enumerate(answer):
    if Adrian[idx] == x: o[0]+=1
    if Bruno[idx] == x: o[1]+=1
    if Goran[idx] == x: o[2]+=1

print(max(o))
for idx,x in enumerate(o):
    if x == max(o): print(name[idx])
