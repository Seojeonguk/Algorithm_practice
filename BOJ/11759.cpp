#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int s, v1, v2;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &s, &v1, &v2);

	for (int i = s / v1; i >= 0; i--) {
		if ((s - v1 * i) % v2 == 0) {
			printf("%d %d\n", i, (s - v1 * i) / v2);
			return 0;
		}
	}

	puts("Impossible");
}