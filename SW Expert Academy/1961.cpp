#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t, n, arr[8][8],ans[8][8];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	for (int tc = 1; tc <= t; tc++) {
		scanf("%d", &n);

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				scanf("%d", &arr[i][j]);
		printf("#%d\n", tc);
		for (int i = 0; i < n; i++) {
			for (int j = n - 1; j >= 0; j--) printf("%d", arr[j][i]);
			printf(" ");

			for (int j = n - 1; j >= 0; j--) printf("%d", arr[n-i-1][j]);
			printf(" ");

			for (int j = 0; j < n;j++) printf("%d", arr[j][n-i-1]);
			printf("\n");
		}
	}
}