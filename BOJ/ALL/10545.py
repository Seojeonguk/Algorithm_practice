import sys
input=sys.stdin.readline

line = input().rstrip('\n').split()
message = input()
prev_idx=0

trend = [[],[],['a','b','c'],"def","ghi","jkl","mno","pqrs","tuv","wxyz"]
new_trend=[0]*12

for _ in range(0,9):
    new_trend[_+1] = trend[(int)(line[_])]

for _ in message:
    for __ in range(1,10):
        if _ in new_trend[__]:
            if prev_idx == __: print('#',end='')
            for id in range(new_trend[__].index(_)+1):
                print(__,end='')
            prev_idx = __;
            break
