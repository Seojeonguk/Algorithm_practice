#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, coin;
int cnt[2], now = -1;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf("%d", &coin);
		if (now != coin) {
			cnt[coin]++;
			now = coin;
		}
	}

	printf("%d\n", min(cnt[0], cnt[1]));
}