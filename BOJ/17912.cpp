#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n,x,m,ans;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);
	m = 1e10;
	for (int i = 0; i < n; i++) {
		scanf("%d", &x);
		if (m > x) {
			ans = i;
			m = x;
		}
	}
	printf("%d\n", ans);
}