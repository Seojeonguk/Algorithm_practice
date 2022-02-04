import sys
input=sys.stdin.readline

t = input().split('|')

ADE = "ADE"
CFG = "CFG"
ade=0
cfg=0
size=0

for _ in t:
    if _[0] in ADE :ade+=1
    elif _[0] in CFG : cfg+=1
    size = len(_)

if ade==cfg:
    ade += (t[len(t)-1][size-2] in ADE)
    cfg += (t[len(t)-1][size-2] in CFG)

if ade<cfg:print("C-major")
elif ade>cfg:print("A-minor")
