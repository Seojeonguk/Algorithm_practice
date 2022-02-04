#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int cnt[1003], n, x;

int gcd(int x, int y) {
	if (!y) return x;
	return gcd(y, x%y);
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	cnt[1] = 2;
	for (int i = 1; i <= 1000; i++) {
		for (int j = 1; j <= 1000; j++)
			if (gcd(i, j) == 1) {
				cnt[max(i, j)]++;
			}
	}
	for (int i = 1; i <= 1000; i++) cnt[i] += cnt[i - 1];

	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf("%d", &x);
		printf("%d\n", cnt[x]);
	}
}