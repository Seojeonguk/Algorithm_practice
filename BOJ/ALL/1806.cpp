#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, s,arr[100003],sum,ans;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	int l = 0, r = 0;
	scanf("%d %d", &n, &s);
	ans = 999999;
	for (int i = 0; i < n; i++) scanf("%d", &arr[i]);

	while (l <= r) {
		if (sum > s || r == n) sum -= arr[l++];
		else if (sum <= s) sum += arr[r++];

		if (sum >= s) ans = min(ans, r - l);
	}

	printf("%d\n", ans == 999999 ?0:ans );
}