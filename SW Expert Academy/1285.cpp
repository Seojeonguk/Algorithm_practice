#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int t, n;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d", &t);

	for (int tc = 1; tc <= t; tc++) {
		scanf("%d", &n);
		int x;
		int cnt = 0;
		int now_dis = 10000000;
		for (int i = 0; i < n; i++) {
			scanf("%d", &x);
			if (abs(x) < now_dis) {
				now_dis = abs(x);
				cnt = 1;
			}
			else if (abs(x) == now_dis) cnt++;
		}

		printf("#%d %d %d\n", tc, now_dis,cnt);
	} 
}