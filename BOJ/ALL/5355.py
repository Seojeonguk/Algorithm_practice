for _ in range(int(input())):
	l = input().split(); s=float(l[0])
	for i in l[1:]:
		s = s*3 if i=='@' else s+5 if i=='%' else s-7
	print('{:.2f}'.format(s))
