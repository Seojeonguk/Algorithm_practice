a_k = map(int, raw_input().split())
if((a_k[0]+1)/2<a_k[1]): print(2*(a_k[1]-(a_k[0]+1)/2))
else: print(1+2*(a_k[1]-1))
