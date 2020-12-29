t = int(input())

for _ in range(t):
    adam = list(map(float,input().split()))
    gosia = list(map(float,input().split()))

    adam_win = adam[0]*gosia[1] + adam[1]*gosia[2] + adam[2]*gosia[0]
    gosia_win = gosia[0]*adam[1]+gosia[1]*adam[2]+gosia[2]*adam[0]

    if adam_win < gosia_win: print("GOSIA")
    elif gosia_win < adam_win: print("ADAM")
    else: print("=")
