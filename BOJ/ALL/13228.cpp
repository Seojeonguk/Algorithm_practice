#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t, x[2], y[2], floo[2];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	while (t--) {
		for (int i = 0; i < 2; i++) scanf("%d %d %d", &x[i], &y[i], &floo[i]);

		printf("%d\n", floo[0] + floo[1] + abs(x[0] - x[1]) + abs(y[0] - y[1]));
	}
}