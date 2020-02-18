#ifdef _DEBUG
#include "bits_stdc++.h"
#else
#include "bits/stdc++.h"
#endif
#pragma warning(disable:4996)
using namespace std;
long long int m;
int n;
pair<int, int> ab[100005];
int main() {
#ifdef _CONSOLE 
	freopen("sample.txt", "r", stdin);
#endif
	scanf("%d %lld", &n, &m);
	for (int i = 0; i < n; i++) scanf("%d", &ab[i].first);
	for (int i = 0; i < n; i++) scanf("%d", &ab[i].second);
	sort(ab, ab + n);

	for (int i = 0; i < n; i++) {
		if (ab[i].second <= ab[i].first) continue;
		if (ab[i].first <= m) m += ab[i].second - ab[i].first;
	}
	printf("%lld\n", m);
}