#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, w, h, x;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d %d", &n, &w, &h);

	for (int i = 0; i < n; i++) {
		scanf("%d", &x);
		if (w * w + h * h >= x * x) puts("YES");
		else puts("NO");
	}
}