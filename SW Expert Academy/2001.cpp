#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t, n, m, arr[16][16];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	for (int tc = 1; tc <= t; tc++) {
		scanf("%d %d", &n,&m);

		int ans = 0;

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				scanf("%d", &arr[i][j]);

		for (int i = 0; i <= n - m; i++) {
			for (int j = 0; j <= n - m; j++) {
				int sum = 0;
				for (int k = i; k < i + m; k++) {
					for (int l = j; l < j + m; l++) {
						sum += arr[k][l];
					}
				}
				if (sum > ans) ans = sum;
			}
		}

		printf("#%d %d\n", tc, ans);
	}
}