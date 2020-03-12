#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t;
char ttt[5][5],ch;
bool chk() {
	int r = 0, c = 0;
	for (int i = 0; i < 3; i++) {
		r = c = 0;
		for (int j = 0; j < 3; j++) {
			r += (ttt[i][j] == ch);
			c += (ttt[j][i] == ch);
			if (r == 3 || c == 3) return true;
		}
	}

	r = c = 0;
	for (int i = 0; i < 3; i++) {
		r += (ttt[i][i] == ch);
		c += (ttt[2 - i][i] == ch);
		if (r == 3 || c == 3) return true;
	}

	return false;
}
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);
	for (int tc = 1; tc <= t; tc++) {
		for (int i = 0; i < 3; i++) scanf(" %s ", ttt[i]);

		scanf(" %c ", &ch);

		bool chking = false;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++)
				if (ttt[i][j] == '-') {
					ttt[i][j] = ch;
					chking = chk();
					if (chking) break;
					ttt[i][j] = '-';
				}
			if (chking) break;
		}

		printf("Case %d:\n", tc);
		for (int i = 0; i < 3; i++) puts(ttt[i]);
	}
}