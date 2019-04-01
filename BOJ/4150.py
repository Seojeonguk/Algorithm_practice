a = int(raw_input())

c = [0,1]

for i in range (a):
    c.append(c[i]+c[i+1])

print c[a]
