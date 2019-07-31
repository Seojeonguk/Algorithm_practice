n = int(input())
s = input()

A=D=0

for _ in s:
    if _ == 'A': A+=1
    else : D+=1

if A>D : print("Anton")
elif A<D : print("Danik")
else : print("Friendship")
