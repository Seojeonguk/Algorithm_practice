#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t,n;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (scanf("%d", &t); t--;) {
		scanf("%d", &n);
		long long int candy=0,x;
		for (int i = 0; i < n; i++) {
			scanf("%lld", &x);
			candy = (candy + x) % n;
		}
		if (candy%n == 0) puts("YES");
		else puts("NO");
	}
}