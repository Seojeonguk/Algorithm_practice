t = int(input())
test_case = 0

for test_case in range(t):
    a = input().split()
    Sound = []

    while(True):
        b=input()
        if(b[-1] == '?'):break
        Sound.append(b.split()[2])

    for X in a:
        if X in Sound: continue
        print(X, end = ' ')
