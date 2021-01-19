#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t, n, arr[1000002];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	for (int tc = 1; tc <= t; tc++) {
		long long ans = 0;

		scanf("%d", &n);

		for (int i = 0; i < n; i++) scanf("%d", &arr[i]);

		int now = arr[n - 1];
		for (int i = n - 1; i >= 0; i--) {
			if (now >= arr[i] ) {
				ans += (long long)now - arr[i];
			}
			else {
				now = arr[i];
			}
		}
		printf("#%d %lld\n", tc, ans);
	}
}