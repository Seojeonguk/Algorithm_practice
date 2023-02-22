#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, arr[101];
int cases;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (scanf("%d", &n)) {
		if (!n) break;

		for (int i = 0; i < n; i++)
			scanf("%d", &arr[i]);

		double ans = 0;
		if (n & 1) ans = arr[n / 2];
		else ans = (arr[n / 2 - 1] + arr[n / 2]) / 2.0;

		printf("Case %d: %.1lf\n", ++cases, ans);
	}
}
