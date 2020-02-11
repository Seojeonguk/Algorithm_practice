#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
bool chk[501][501];
int n, m, x, y;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	for (int i = 0; i < m; i++) {
		scanf("%d %d", &x, &y);
		chk[x][y] = true;
	}

	for (int k = 1; k <= n; k++)
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++)
				chk[i][j] |= (i == j ? true : (chk[i][k] & chk[k][j]));
		}

	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= n; j++)
			chk[j][i] |= chk[i][j];

	int ans = n;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++)
			if (!chk[i][j]) {
				ans--;
				break;
			}
	}
	printf("%d\n", ans);
}