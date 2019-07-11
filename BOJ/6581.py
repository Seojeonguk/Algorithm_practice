import sys
from sys import stdin
input=sys.stdin.readline

line_message=''
for _ in stdin.read().split():
    if _ == "<br>":
        print(line_message)
        line_message=''
    elif _ == "<hr>":
        if line_message : 
            print(line_message) 
            line_message=''
        print("--------------------------------------------------------------------------------")
    else :
        tmp = line_message + ' ' + _ if line_message else _
        if len(tmp) > 80: 
            print(line_message)
            line_message = _
        else:
            line_message = tmp

if line_message : print(line_message) 
