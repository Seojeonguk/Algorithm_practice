#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t, m,p1,p2;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);
	while (t--) {
		scanf("%d", &m);

		int ans = 0;
		int now = 0;
		for (int i = 0; i < m; i++) {
			scanf("%d %d", &p1, &p2);
			now += p1 - p2;
			if (now < 0) {
				ans += -now;
				now = 0;
			}
		}

		printf("%d\n", ans);
	}
}