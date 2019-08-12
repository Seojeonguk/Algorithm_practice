n = int(input())
sentence = input()
sentence = sentence.lower()

se = set()
for cha in sentence:
    se.add(cha)

if len(se) != 26: print("NO")
else: print("YES")
