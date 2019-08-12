n = int(input())
arr = list(map(int,input().split()))

total=0
for Litter in arr:
    total += Litter
    
print(total/(n*100)*100)
