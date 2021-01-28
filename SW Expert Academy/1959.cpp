#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t, n, m, a[31], b[31];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	for (int tc = 1; tc <= t; tc++) {
		scanf("%d %d", &n, &m);

		for (int i = 0; i < n; i++) scanf("%d", &a[i]);
		for (int i = 0; i < m; i++) scanf("%d", &b[i]);
		
		int ans = 0;
		if (n>=m) {
			for (int i = 0; i <= n - m; i++) {
				int sum = 0;
				for (int j = i; j < i + m; j++) {
					sum += a[j] * b[j - i];
				}
				ans = max(ans, sum);
			}
		}
		else {
			for (int i = 0; i <= m-n; i++) {
				int sum = 0;
				for (int j = i; j < i + n; j++) {
					sum += b[j] * a[j - i];
				}
				ans = max(ans, sum);
			}
		}
		printf("#%d %d\n", tc, ans);
	}
}