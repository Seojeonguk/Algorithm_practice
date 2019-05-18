#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

vector<vector<int> > v;
char arr[12];

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
	v.resize(12);
	v[0].resize(12);
	v[11].resize(12);
	for (int i = 1; i <= 10; i++) {
		scanf(" %s", arr);
		v[i].resize(12);
		for (int j = 1; j <= 10; j++)
			if (arr[j - 1] == '#') v[i][j] = 0;
			else v[i][j] = 1;
	}

	for (int i = 1; i <= 10; i++) {
		for (int j = 1; j <= 10; j++)
			printf("%d", v[i][j]);
		puts("");
	}

	int ans = 987654321;
	for (int i = (1 << 10) - 1; i >= 0; i--) {
		int chk = 0;
		vector<vector<int> > tmp = v;

		for (int k = 0; k < 10; k++)
			if (i & (1 << k)) {
				ch(1, k + 1, tmp);
				chk++;
			}

		for (int k = 2; k <= 10; k++)
			for (int j = 1; j <= 10; j++)
				if (tmp[k - 1][j]) {
					ch(k, j, tmp);
					chk++;
				}
		bool falg = true;

		for (int k = 1; k <= 10; k++)
			if (tmp[10][k]) falg = false;
		if (falg) ans = min(ans, chk);
	}

	printf("%d\n", (ans == 987654321 ? -1 : ans));
}