#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t, n;
char arr[100007][5];

int de(int x, int y) {
	int cnt = 0;
	for (int i = 0; i < 4; i++)
		cnt += (arr[x][i] != arr[y][i]);
	return cnt;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	while (t--) {
		scanf("%d", &n);

		for (int i = 0; i < n; i++) scanf("%s", &arr[i]);

		if (n >= 33) {
			puts("0");
		}
		else {
			int ans = 999999;
			for (int i = 0; i < n; i++) {
				for (int j = i + 1; j < n; j++) {
					for (int k = j + 1; k < n; k++) {
						int a = de(i, j);
						int b = de(i, k);
						int c = de(j, k);

						ans = min(ans, a + b + c);
					}
				}
			}

			printf("%d\n", ans);
		}
	}
}