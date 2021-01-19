#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t, n,arr[11][11];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	for (int tc = 1; tc <= t; tc++) {
		scanf("%d", &n);

		printf("#%d\n", tc);

		for (int i = 1; i <= n; i++) arr[i][i] = arr[i][1] = 1;

		for (int i = 3; i <= n; i++) {
			for (int j = 2; j < i; j++) {
				arr[i][j] = arr[i - 1][j - 1] + arr[i-1][j];
			}
		}

		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				printf("%d ", arr[i][j]);
			}
			printf("\n");
		}
	}
}