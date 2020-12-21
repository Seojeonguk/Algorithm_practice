#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m, k, ans;
char r[53][53];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);
	for (int i = 0; i < n; i++) scanf(" %s", r[i]);
	scanf("%d", &k);

	int cnt, chk;
	for (int i = 0; i < n; i++) {
		cnt = chk = 0;
		for (int j = 0; j < m; j++) if (r[i][j] == '0') cnt++;

		if (cnt <= k && (cnt % 2 == k % 2)) {
			for (int j = 0; j < n; j++) {
				if (strcmp(r[i], r[j]) == 0) chk++;
			}
		}

		ans = max(ans, chk);
	}

	printf("%d\n", ans);
}