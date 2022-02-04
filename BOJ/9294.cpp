#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t, n, m, s, ans[7];

void solve(int idx,int sum) {
	if (idx == n) {
		if (sum == s) {
			printf("(");
			for (int i = 1; i <= n; i++) {
				printf("%d",ans[i]);
				if (i != n) printf(",");
			}
			printf(")\n");
		}
		return;
	}

	for (int i = max(ans[idx],1); i <= m; i++) {
		ans[idx+1] = i;
		solve(idx + 1, sum + i);
	}
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);
	for (int tc = 1; tc <= t; tc++) {
		scanf("%d %d %d", &n, &m, &s);
		printf("Case %d:\n", tc);
		solve(0,0);
	}
}