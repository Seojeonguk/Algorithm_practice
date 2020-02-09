#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int x, y;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &x, &y);
	for (int i = 2;; i++) {
		if (x*i == y || i - x * i / y >= 2) {
			printf("%d\n", i);
			return 0;
		}
	}
}