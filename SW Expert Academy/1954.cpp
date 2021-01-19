#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t, n, arr[9][9];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	for (int tc = 1; tc <= t; tc++) {
		scanf("%d", &n);
		memset(arr, 0, sizeof arr);
		int now = 1;
		for (int i = 0; i < n / 2; i++) {
			for (int j = i; j < n - i; j++) arr[i][j] = now++;

			for (int j = i + 1; j < n - i; j++) arr[j][n-i-1] = now++;

			for (int j = i + 1; j < n - i; j++) arr[n - i - 1][n - j - 1] = now++;

			for (int j = i + 1; j < n - i-1; j++) arr[n - j - 1][i] = now++;
		}

		if (n & 1) arr[n / 2][n / 2] = now;

		printf("#%d\n", tc);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++)
				printf("%d ", arr[i][j]);
			puts("");
		}
	}
}