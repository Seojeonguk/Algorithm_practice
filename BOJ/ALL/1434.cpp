#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;

int n, m, box[52], x;

int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &n, &m);

	for (int i = 0; i < n; i++) scanf("%d", &box[i]);

	int idx = 0, ans = 0;
	for (int i = 0; i < m; i++) {
		scanf("%d", &x);

		while (idx < n) {
			if (box[idx] >= x) {
				box[idx] -= x;
				break;
			}
			else {
				ans += box[idx];
				idx++;
			}
		}
	}

	for (int i = idx; i < n; i++) ans += box[i];

	printf("%d\n", ans);
}