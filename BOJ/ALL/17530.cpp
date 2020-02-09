#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, x,y;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &x);
	for (int i = 0; i < n - 1; i++) {
		scanf("%d", &y);
		if (y > x) {
			puts("N");
			return 0;
		}
	}
	puts("S");
}