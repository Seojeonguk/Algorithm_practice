g=lambda:map(int,input().split())
a,s=g()
d,f=g()

if a*f<s*d*3.14159265359*d: print('Whole pizza')
else: print('Slice of pizza')
