#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, d, v, f, c;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	int tc;
	scanf("%d", &tc);
	while (tc--) {
		scanf("%d %d", &n, &d);
		int cnt = 0;

		for (int i = 0; i < n; i++) {
			scanf("%d %d %d", &v, &f, &c);
			double meter = v * (f / c);
			if (f%c) meter += (v * (f%c)) / c;
			if (d <= meter) cnt++;
		}

		printf("%d\n", cnt);
	}
}