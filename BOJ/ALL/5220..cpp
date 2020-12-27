#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t, n, b;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);
	while (t--) {
		scanf("%d %d", &n, &b);

		int cnt = 0;
		while (n) {
			cnt += n & 1;
			n >>= 1;
		}
		puts((cnt & 1) == b ? "Valid" : "Corrupt");
	}
}