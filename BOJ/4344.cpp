#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t,n,cnt,scores[1001];
 
int main() {
#ifdef _CONSOLE 
    freopen("sample.txt", "r", stdin);
#endif
	scanf("%d",&t);
	while(t--) {
		double sum=0,ratio=0;
		cnt=0;
		scanf("%d",&n);
		
		for(int i=0;i<n;i++) {
			scanf("%d",&scores[i]);
			sum += 1.0f * scores[i];
		}
		
		ratio = sum/(double)n;
		
		for(int i=0;i<n;i++) 
			if(ratio < scores[i]) 
				cnt++;
			
		printf("%.3lf%\n",round(100000.0*cnt/n)/1000.0);
	}
}