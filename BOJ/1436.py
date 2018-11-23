n = 666
n=int(raw_input())
cnt=1
m=666
while(True):
	v= str(m)
	if(v.find('666') != -1):
		if(cnt == n):
			print(m)
			exit(0)
		cnt+=1
	m+=1
