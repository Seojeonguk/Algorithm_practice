#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n,x;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (int t = 1;scanf("%d",&n),n!=0; t++) {
		int ans = 0;
		for(int i=1;i<=n;i++) 
			for (int j = 1; j <= i; j++) {
				scanf("%d", &x);
				if (j == 1 || i == n || i == j) ans += x;
			}
		printf("Case #%d:%d\n", t, ans);
	}
}