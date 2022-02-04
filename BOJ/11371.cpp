#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int n, m;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	while (1) {
		scanf("%d %d", &n, &m);
		if (n + m == 0) break;
		printf("%d\n", (int)(atan2(m, n) * 180 / 3.14 + 0.5));
	}
}