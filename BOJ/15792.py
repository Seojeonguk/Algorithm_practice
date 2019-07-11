from decimal import *
getcontext().prec=5
a,b=map(Decimal,input().split())
print(a/b)
