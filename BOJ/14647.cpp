#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, m, bingo[502][502],all_nine,max_nine,sum_nine;

int count_nine(int x) {
	int ret = 0;
	while (x) {
		if (x % 10 == 9) ret++;
		x /= 10;
	}
	return ret;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	for (int i = 0; i < n; i++) {
		sum_nine = 0;
		for (int j = 0; j < m; j++) {
			scanf("%d", &bingo[i][j]);
			bingo[i][j] = count_nine(bingo[i][j]);
			all_nine += bingo[i][j];
			sum_nine += bingo[i][j];
		}
		max_nine = max(max_nine, sum_nine);
	}

	for (int i = 0; i < m; i++) {
		sum_nine = 0;
		for (int j = 0; j < n; j++) sum_nine += bingo[j][i];
		max_nine = max(max_nine, sum_nine);
	}

	printf("%d\n", all_nine - max_nine);
}