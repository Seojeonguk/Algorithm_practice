#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int t, x;
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	for (scanf("%d", &t); t--;) {
		scanf("%d", &x);
		int ans = 0;
		for (int i = 2; i <= x; i++)
			if (x%i == 0) {
				for (int k = x; k%i == 0; k /= i)
					ans++;
			}
		printf("%d\n", ans);
	}
}