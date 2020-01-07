#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, x;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &n);

	for (int i = 0; i < n; i++) {
		scanf("%d", &x);
		if (x == 1) {
			puts("HARD");
			return 0;
		}
	}
	puts("EASY");
}