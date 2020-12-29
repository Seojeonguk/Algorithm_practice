#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t, x, w;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	while (t--) {
		scanf("%d %d", &x, &w);
		int cnt = 0;
		while (x<w) {
			x *= 2;
			cnt++;
		}
		printf("%d\n", cnt);
	}
}