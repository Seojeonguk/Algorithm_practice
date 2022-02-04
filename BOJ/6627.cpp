#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n;

int cal(int x) {
	int cnt = 0;
	while (x) {
		cnt += x % 10;
		x /= 10;
	}
	return cnt;
}

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (1) {
		scanf("%d", &n);
		if (!n) break;

		int now = 11;

		int Sn = cal(n);

		while (1) {
			if (Sn == cal(n*now)) break;
			now++;
		}

		printf("%d\n", now);

	}
}