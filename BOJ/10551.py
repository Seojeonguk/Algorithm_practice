import sys
input=sys.stdin.readline

text = input().rstrip('\n')
tiping = ["1QAZ","2WSX","3EDC","45RTFGVB","67YUHJNM","8IK,","9OL.","0P;/'[]-="]

cnt=[0]*8

for _ in text:
    for t in range(8):
        if _ in tiping[t]:
            cnt[t] += 1
            break

for _ in range(8):
    print(cnt[_])
