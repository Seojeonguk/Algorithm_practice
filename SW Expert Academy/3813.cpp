#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t, n,k;
int w[200002],s[200002];

bool solve(int mid) {
	int cnt = 0, now = 0;
	for (int i = 0; i < n; i++) {
		if (w[i] <= mid) cnt++;
		else cnt = 0;
		if (cnt == s[now]) {
			cnt = 0;
			if (++now == k)
				break;
		}
	}
	return now == k;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	for (int tc = 1; tc <= t; tc++) {
		scanf("%d %d", &n, &k);

		for (int i = 0; i < n; i++) scanf("%d", &w[i]);
		for (int i = 0; i < k; i++) scanf("%d", &s[i]);

		int l = 0, r = 200002;
		while (l < r) {
			int mid = (l + r) / 2;
			if (solve(mid)) r = mid;
			else l = mid + 1;
		}

		printf("#%d %d\n", tc, l);
	}
}