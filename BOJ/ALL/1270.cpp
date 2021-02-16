#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, t;
long long x,ans;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf("%d", &t);
		map<long long, int> m;
		bool chk = false;
		for (int j = 0; j < t; j++) {
			scanf("%lld", &x);
			m[x]++;
			if (m[x] > t / 2) {
				ans = x;
				chk = true;
			}
		}
		if (chk) printf("%lld\n", ans);
		else puts("SYJKGW");
	}
}