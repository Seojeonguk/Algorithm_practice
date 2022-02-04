#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t, n;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);
	while (t--) {
		scanf("%d", &n);
		int sq = n * n;
		if (n < 10) sq %= 10;
		else if (n < 100) sq %= 100;
		else if (n < 1000) sq %= 1000;

		if (sq == n) puts("YES");
		else puts("NO");
	}
}