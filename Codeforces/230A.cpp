#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
int s, n;
pair<int, int> p[1004];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %d", &s, &n);

	for (int i = 0; i < n; i++) scanf("%d %d", &p[i].first, &p[i].second);

	sort(p, p + n);

	for (int i = 0; i < n; i++) {
		if (s > p[i].first) s += p[i].second;
		else {
			puts("NO");
			return 0;
		}
	}
	puts("YES");
}