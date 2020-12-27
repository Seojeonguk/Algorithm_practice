#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, k, si, ti, ri;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &k);

	while (k--) {
		scanf("%d %d %d", &si, &ti, &ri);

		int ans = 0, read_page = 0,read_cnt=0;
		while (read_page < n) {
			if (read_cnt == ti) {
				ans += ri;
				read_cnt = 0;
			}
			else {
				read_cnt++;
				ans++;
				read_page += si;
			}
		}

		printf("%d\n", ans);
	}
}