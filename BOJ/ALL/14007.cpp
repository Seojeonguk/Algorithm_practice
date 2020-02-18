#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n,a[102],ans;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);
	ans = n;
	for (int i = 0; i < n; i++) scanf("%d", &a[i]);
	a[n] = a[n - 1];

	for (int i = 0; i < n; i++) {
		if (a[i] != a[i + 1]) ans++;

		for (int j = i+2; j < n; j++) {
			printf("%d %d\n", i, j);
			int cnt = 0;
			for (int k = i + 1; k < j; k++)
				if (a[k] > a[k - 1] && a[k] > a[k + 1]) cnt++;
				else if (a[k] < a[k - 1] && a[k] < a[k + 1]) cnt++;

			if (cnt == j-i - 1) ans++;
			else break;
		}
	}

	printf("%d\n", ans);
}