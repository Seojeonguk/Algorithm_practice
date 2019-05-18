#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

vector<vector<int> > v;
int n, x;

void ch(int x, int y, vector<vector<int> > &V) {
	V[x][y] = !V[x][y];
	V[x - 1][y] = !V[x - 1][y];
	V[x + 1][y] = !V[x + 1][y];
	V[x][y - 1] = !V[x][y - 1];
	V[x][y + 1] = !V[x][y + 1];
}
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);
	v.resize(n+2);
	v[0].resize(n + 2);
	v[n + 1].resize(n + 2);
	for (int i = 1; i <= n; i++) {
		v[i].resize(n + 2);
		for (int j = 1; j <= n; j++)
			scanf("%d", &v[i][j]);
	}

	int ans = 987654321;
	for (int i = (1 << n) - 1; i>=0; i--) {
		int chk = 0;
		vector<vector<int> > tmp = v;

		for(int k=0;k<n;k++)
			if (i & (1 << k)) {
				ch(1, k+1, tmp);
				chk++;
			}

		for(int k=2;k<=n;k++)
			for(int j=1;j<=n;j++)
				if (tmp[k - 1][j]) {
					ch(k, j, tmp);
					chk++;
				}
		bool falg = true;

		for (int k = 1; k <= n; k++)
			if (tmp[n][k]) falg = false;
		if (falg) ans = min(ans, chk);
	}

	printf("%d\n", (ans == 987654321 ? -1 : ans));
}