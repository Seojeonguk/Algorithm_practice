#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, m, nm[10], chk[10001];
int ans[10];

void solve(int cnt, int idx) {
	if (cnt == m) {
		for (int i = 0; i < m; i++) printf("%d ", ans[i]);
		puts("");
		return;
	}

	for (int i = idx; i <= 10000; i++)
		if (chk[i]) {
			chk[i]--;
			ans[cnt] = i;
			solve(cnt + 1, i);
			chk[i]++;
		}
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	for (int i = 0; i < n; i++) {
		scanf("%d", &nm[i]);
		chk[nm[i]] = (chk[nm[i]] + 1) >= m ? m : chk[nm[i]] + 1;
	}
	solve(0, 0);
}