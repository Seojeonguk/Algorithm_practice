#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int a[102], n, g[4],ans_max=-1000000001,ans_min=1000000001;

void solve(int idx,int sum) {
	if (idx == n-1) {
		ans_max = max(ans_max, sum);
		ans_min = min(ans_min, sum);
		return;
	}

	for (int i = 0; i < 4; i++) {
		if (g[i]) {
			g[i] -= 1;
			if (i == 0) solve(idx + 1, sum + a[idx + 1]);
			else if (i == 1) solve(idx + 1, sum - a[idx + 1]);
			else if (i == 2) solve(idx + 1, sum*a[idx + 1]);
			else if (i == 3) solve(idx + 1, sum / a[idx + 1]);
			g[i] += 1;
		}
	}
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);
	for (int i = 0; i < n; i++) scanf("%d", &a[i]);
	for (int i = 0; i < 4; i++) scanf("%d", &g[i]);
	solve(0,a[0]);
	printf("%d\n%d\n", ans_max, ans_min);
}