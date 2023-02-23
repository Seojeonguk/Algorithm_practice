#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
typedef long long ll;

int n, k, numbers[1001];
bool dp[50002][52];

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	dp[0][1] = true;
	for (int i = 1; i <= n; i++) {
		scanf("%d", &numbers[i]);
		dp[numbers[i]][1] = true;
	}
	scanf("%d", &k);

	for (int i = 0; i <= 50000; i++) {
		for (int j = 1; j < k; j++) {
			if (dp[i][j]) {
				for (int l = 0; l <= n; l++) {
					dp[i + numbers[l]][j + 1] = true;
				}
			}
		}
	}

	for (int i = 1;; i++) {
		if (!dp[i][k]) {
			printf("%s win at %d\n", i & 1 ? "jjaksoon" : "holsoon", i);
			break;
		}
	}
}
