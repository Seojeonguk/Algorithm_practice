#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, m, x, y, z, dist[102][102];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);
	for (int i = 1; i <= n; i++) for (int j = 1; j <= n; j++) dist[i][j] = 1 << 29;
	for (int i = 0; i < m; i++) {
		scanf("%d %d %d", &x, &y, &z);
		dist[x][y] = min(dist[x][y], z);
	}

	for (int k = 1; k <= n; k++) {
		for (int i = 1; i <= n; i++) {
			if (!dist[i][k]) break;
			for (int j = 1; j <= n; j++) {
				dist[i][j] = (i == j) ? 1 << 29 : min(dist[i][j], dist[i][k] + dist[k][j]);
			}
		}
	}

	for (int i = 1; i <= n; i++, puts(""))
		for (int j = 1; j <= n; j++) printf("%d ", dist[i][j] == 1 << 29 ? 0 : dist[i][j]);
}